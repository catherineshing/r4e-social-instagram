package com.reputation.social.instagram.api.impl;

import com.reputation.social.instagram.api.CommentOperations;

class CommentTemplate extends AbstractInstagramOperations implements CommentOperations {

	public CommentTemplate(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		super(instagramTemplate, isAuthorized);
	}
}
