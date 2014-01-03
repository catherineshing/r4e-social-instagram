package com.reputation.social.instagram.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import com.reputation.social.instagram.api.Instagram;
import com.reputation.social.instagram.api.impl.InstagramTemplate;

public class InstagramServiceProvider extends AbstractOAuth2ServiceProvider<Instagram> {
	
	private final String clientId;
	
	public InstagramServiceProvider(String clientId, String clientSecret) {
		super(new InstagramOAuth2Template(clientId, clientSecret));
		this.clientId = clientId;
	}

	@Override
	public Instagram getApi(String accessToken) {
		return new InstagramTemplate(clientId, accessToken);
	}
}
