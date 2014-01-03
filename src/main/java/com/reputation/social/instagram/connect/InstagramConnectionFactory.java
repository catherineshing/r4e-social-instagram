package com.reputation.social.instagram.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.reputation.social.instagram.api.Instagram;

public class InstagramConnectionFactory extends OAuth2ConnectionFactory<Instagram> {

	public InstagramConnectionFactory(String clientId, String clientSecret) {
		super("instagram", new InstagramServiceProvider(clientId, clientSecret),
				new InstagramAdapter());
	}
}
