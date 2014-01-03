package com.reputation.social.instagram.api.impl;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class InstagramProfileMixin {
	@JsonCreator
	InstagramProfileMixin(
			@JsonProperty("id") long id, 
			@JsonProperty("username") String username,
			@JsonProperty("full_name") String fullName,
			@JsonProperty("profile_picture") String profilePic,
			@JsonProperty("counts") Map<String, Integer> counts) {
	}

	@JsonProperty("bio")
	String bio;

	@JsonProperty("website")
	String website;

	@JsonProperty("first_name")
	String firstName;

	@JsonProperty("last_name")
	String lastName;
}
