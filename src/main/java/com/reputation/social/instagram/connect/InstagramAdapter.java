package com.reputation.social.instagram.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

import com.reputation.social.instagram.api.Instagram;
import com.reputation.social.instagram.api.InstagramProfile;

public class InstagramAdapter implements ApiAdapter<Instagram> {

	@Override
	public boolean test(Instagram instagram) {
		try {
			instagram.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	@Override
	public void setConnectionValues(Instagram instagram, ConnectionValues values) {
		InstagramProfile profile = instagram.userOperations().getUserProfile();
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName(profile.getUsername());
		values.setImageUrl(profile.getProfilePic());
	}

	@Override
	public UserProfile fetchUserProfile(Instagram instagram) {
		InstagramProfile profile = instagram.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getFullName())
				.setUsername(profile.getUsername()).build();
	}

	@Override
	public void updateStatus(Instagram instagram, String message) {
		// TODO Auto-generated method stub
	}
}