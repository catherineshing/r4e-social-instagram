package com.reputation.social.instagram.api.impl;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

class AbstractInstagramOperations {

	private static final String API_URL_BASE = "https://api.instagram.com/v1/";

	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

	private final boolean isAuthorized;

	protected final InstagramTemplate instagramTemplate;

	public AbstractInstagramOperations(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		this.instagramTemplate = instagramTemplate;
		this.isAuthorized = isAuthorized;
	}

	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("instagram");
		}
	}

	protected <T> T get(URI uri, Class<T> responseType) {
		return instagramTemplate.getRestTemplate().getForObject(uri, responseType);
	}

	protected <C> C post(URI uri, MultiValueMap<String, String> data, Class<C> responseType) {
		MultiValueMap<String, String> requestData = new LinkedMultiValueMap<String, String>(data);
		return instagramTemplate.getRestTemplate().postForObject(uri, requestData, responseType);
	}
	
	// TODO - put
	// post with _method=PUT
	
	protected void delete(URI uri) {
		instagramTemplate.getRestTemplate().delete(uri);
	}

	protected URI buildUri(String path) {
		return buildUri(path, EMPTY_PARAMETERS);
	}

	protected URI buildUri(String path, String parameterName, String parameterValue) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set(parameterName, parameterValue);
		return buildUri(path, parameters);
	}

	protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
		if (!StringUtils.isEmpty(instagramTemplate.getAccessToken())) {
			parameters.add("access_token", instagramTemplate.getAccessToken());
		} else if (!StringUtils.isEmpty(instagramTemplate.getClientId())) {
			parameters.add("client_id", instagramTemplate.getClientId());
		}
		return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
	}
}