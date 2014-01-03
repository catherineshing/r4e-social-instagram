package com.reputation.social.instagram.api.impl;

import com.reputation.social.instagram.api.MediaOperations;

class MediaTemplate extends AbstractInstagramOperations implements MediaOperations {

	public MediaTemplate(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		super(instagramTemplate, isAuthorized);
	}
}
