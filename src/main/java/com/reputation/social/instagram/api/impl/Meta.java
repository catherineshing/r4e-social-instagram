package com.reputation.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Meta {
	private int code;

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
}
