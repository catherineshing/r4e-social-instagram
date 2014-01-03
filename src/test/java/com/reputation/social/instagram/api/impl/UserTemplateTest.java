package com.reputation.social.instagram.api.impl;

import org.junit.Test;
import static org.junit.Assert.*;

import com.reputation.social.instagram.api.InstagramProfile;

public class UserTemplateTest {

	private final long userId = 265441826;
	private final String accessToken = "909299523.fd22c50.aa5244e4844940e984a3300c51f2010b";

	@Test
	public void testGetSelfProfile() {

	}

	@Test
	public void testGetUserProfile() {
		try {
			InstagramTemplate template = new InstagramTemplate(accessToken);
			InstagramProfile profile = template.userOperations().getUserProfile(userId);
			System.out.println(profile.getUsername() + ", mediaCount: " + profile.getMediaCount());
			assertNotNull(profile);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
