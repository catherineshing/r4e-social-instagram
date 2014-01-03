package com.reputation.social.instagram.api.impl;

import com.reputation.social.instagram.api.InstagramProfile;
import com.reputation.social.instagram.api.UserOperations;

class UserTemplate extends AbstractInstagramOperations implements UserOperations {

	public UserTemplate(InstagramTemplate instagramTemplate, boolean isAuthorized) {
		super(instagramTemplate, isAuthorized);
	}

	public long getProfileId() {
		requireAuthorization();
		return getUserProfile().getId();
	}

	public String getUserName() {
		requireAuthorization();
		return getUserProfile().getUsername();
	}

	@Override
	public InstagramProfile getUserProfile() {
		requireAuthorization();
		return get(buildUri(USERS_ENDPOINT + "self"), InstagramProfile.class).getData();
	}

	@Override
	public InstagramProfile getUserProfile(long userId) {
		requireAuthorization();
		return get(buildUri(USERS_ENDPOINT + String.valueOf(userId)), InstagramProfile.class)
				.getData();
	}

	@Override
	public InstagramProfile search(String name) {
		requireAuthorization();
		return get(buildUri(USERS_ENDPOINT + "search?q=" + name + "&count=1"),
				InstagramProfile.class).getData();
	}
}