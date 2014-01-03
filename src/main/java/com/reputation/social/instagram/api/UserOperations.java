package com.reputation.social.instagram.api;

public interface UserOperations {

	public static final String USERS_ENDPOINT = "users/";

	InstagramProfile getUserProfile();

	InstagramProfile getUserProfile(long userId);

	InstagramProfile search(String name);
}
