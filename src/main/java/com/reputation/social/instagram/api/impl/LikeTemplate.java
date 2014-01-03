package com.reputation.social.instagram.api.impl;

import com.reputation.social.instagram.api.LikeOperations;

class LikeTemplate extends AbstractInstagramOperations implements LikeOperations {

	public LikeTemplate(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		super(instagramTemplate, isAuthorized);
	}
}
