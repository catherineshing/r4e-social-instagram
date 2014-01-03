package com.reputation.social.instagram.api.impl;

import com.reputation.social.instagram.api.RelationshipOperations;

class RelationshipTemplate extends AbstractInstagramOperations implements RelationshipOperations {

	public RelationshipTemplate(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		super(instagramTemplate, isAuthorized);
	}
}
