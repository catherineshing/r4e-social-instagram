package com.reputation.social.instagram.api.impl;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

class InstagramErrorHandler extends DefaultResponseErrorHandler {
	private static final Logger logger = LoggerFactory.getLogger(InstagramErrorHandler.class);

	private static final String PROVIDER_ID = "instagram";

//	private static final int TOO_MANY_REQUESTS = 503;

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		if (statusCode.series() == Series.SERVER_ERROR) {
			handleServerErrors(statusCode);
		} else if (statusCode.series() == Series.CLIENT_ERROR) {
			handleClientErrors(response);
		}

		// if not otherwise handled, do default handling and wrap with
		// UncategorizedApiException
		try {
			super.handleError(response);
		} catch (Exception e) {
			throw new UncategorizedApiException(PROVIDER_ID, "Error consuming Instagram REST API",
					e);
		}
	}

	private void handleClientErrors(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		Map<String, Object> errorMap = extractErrorDetailsFromResponse(response);

		int errorCode = (Integer) errorMap.get("code");
		String errorType = (String) errorMap.get("error_type");
		String errorMessage = (String) errorMap.get("error_message");
		logger.debug("StatusCode: " + statusCode + ", ErrorCode: " + errorCode + ", ErrorType: "
				+ errorType + ", ErrorMessage: " + errorMessage);

		if (statusCode == HttpStatus.BAD_REQUEST) {
			if (errorMessage.contains("missing")
					&& (errorMessage.contains("client_id") || errorMessage.contains("access_token"))) {
				throw new MissingAuthorizationException(PROVIDER_ID);
			} else if (errorMessage.contains("access_token") && errorMessage.contains("invalid")) {
				throw new InvalidAuthorizationException(PROVIDER_ID, errorMessage);
			}
		}
	}

	private void handleServerErrors(HttpStatus statusCode) throws IOException {

	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		Map<String, Object> responseMap = mapper.<Map<String, Object>> readValue(
				response.getBody(), new TypeReference<Map<String, Object>>() {
				});
		if (responseMap.containsKey("meta")) {
			Map<String, Object> meta = (Map<String, Object>) responseMap.get("meta");
			if (Integer.valueOf(String.valueOf(meta.get("code"))).intValue() > 200) {
				return meta;
			}
		}
		return null;
	}
}