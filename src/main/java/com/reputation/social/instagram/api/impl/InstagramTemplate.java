package com.reputation.social.instagram.api.impl;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reputation.social.instagram.api.CommentOperations;
import com.reputation.social.instagram.api.Instagram;
import com.reputation.social.instagram.api.LikeOperations;
import com.reputation.social.instagram.api.MediaOperations;
import com.reputation.social.instagram.api.RelationshipOperations;
import com.reputation.social.instagram.api.UserOperations;

public class InstagramTemplate extends AbstractOAuth2ApiBinding implements Instagram {

	private CommentOperations commentOperations;

	private LikeOperations likeOperations;

	private MediaOperations mediaOperations;

	private RelationshipOperations relationshipOperations;

	private UserOperations userOperations;

	private String applicationNamespace;

	private String clientId;

	private String accessToken;

	public InstagramTemplate() {
		initialize();
	}

	public InstagramTemplate(String accessToken) {
		this(null, accessToken, null);
	}

	public InstagramTemplate(String clientId, String accessToken) {
		this(clientId, accessToken, null);
	}

	public InstagramTemplate(String clientId, String accessToken, String applicationNamespace) {
		super(accessToken);
		this.clientId = clientId;
		this.accessToken = accessToken;
		this.applicationNamespace = applicationNamespace;
		initialize();
	}

	public CommentOperations commentOperations() {
		return commentOperations;
	}

	public LikeOperations likeOperations() {
		return likeOperations;
	}

	public MediaOperations mediaOperations() {
		return mediaOperations;
	}

	public RelationshipOperations relationshipOperations() {
		return relationshipOperations;
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	public String getApplicationNamespace() {
		return applicationNamespace;
	}

	public String getClientId() {
		return clientId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER_DRAFT_2;
	}

	@Override
	protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
		converter.setObjectMapper(new ObjectMapper().registerModule(new InstagramModule()));
		return converter;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new InstagramErrorHandler());
	}

	private void initialize() {
		// super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate()
		// .getRequestFactory()));
		initSubApis();
	}

	private void initSubApis() {
		commentOperations = new CommentTemplate(this, isAuthorized());
		likeOperations = new LikeTemplate(this, isAuthorized());
		mediaOperations = new MediaTemplate(this, isAuthorized());
		relationshipOperations = new RelationshipTemplate(this, isAuthorized());
		userOperations = new UserTemplate(this, isAuthorized());
	}
}