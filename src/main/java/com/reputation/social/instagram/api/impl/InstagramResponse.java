package com.reputation.social.instagram.api.impl;

public class InstagramResponse<T> {
	private Pagination pagination;
	private Meta meta;
	private T data;

	/**
	 * @return the pagination
	 */
	public Pagination getPagination() {
		return pagination;
	}

	/**
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
}
