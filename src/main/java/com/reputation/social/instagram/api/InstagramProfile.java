package com.reputation.social.instagram.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reputation.social.instagram.api.impl.InstagramResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramProfile extends InstagramResponse<InstagramProfile> {
	public static final String MEDIA_COUNT = "media";
	public static final String FOLLOWED_BY_COUNT = "followed_by";
	public static final String FOLLOWS_COUNT = "follows";

	private long id;
	private String username;
	private String bio;
	private String website;
	private String profilePic;
	private String fullName;
	private String firstName;
	private String lastName;
	private Map<String, Integer> counts;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio
	 *            the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * @param profilePic
	 *            the profilePic to set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the counts
	 */
	public Map<String, Integer> getCounts() {
		return counts;
	}

	/**
	 * @param counts
	 *            the counts to set
	 */
	public void setCounts(Map<String, Integer> counts) {
		this.counts = counts;
	}

	/**
	 * @return the mediaCount
	 */
	public int getMediaCount() {
		return null == counts ? 0 : counts.get(MEDIA_COUNT);
	}

	/**
	 * @param mediaCount
	 *            the mediaCount to set
	 */
	public void setMediaCount(int mediaCount) {
		if (CollectionUtils.isEmpty(counts)) {
			counts = new HashMap<String, Integer>();
		}
		counts.put(MEDIA_COUNT, mediaCount);
	}

	/**
	 * @return the followedByCount
	 */
	public int getFollowedByCount() {
		return null == counts ? 0 : counts.get(FOLLOWED_BY_COUNT);
	}

	/**
	 * @param followedByCount
	 *            the followedByCount to set
	 */
	public void setFollowedByCount(int followedByCount) {
		if (CollectionUtils.isEmpty(counts)) {
			counts = new HashMap<String, Integer>();
		}
		counts.put(FOLLOWED_BY_COUNT, followedByCount);
	}

	/**
	 * @return the followsCount
	 */
	public int getFollowsCount() {
		return null == counts ? 0 : counts.get(FOLLOWS_COUNT);
	}

	/**
	 * @param followsCount
	 *            the followsCount to set
	 */
	public void setFollowsCount(int followsCount) {
		if (CollectionUtils.isEmpty(counts)) {
			counts = new HashMap<String, Integer>();
		}
		counts.put(FOLLOWS_COUNT, followsCount);
	}
}