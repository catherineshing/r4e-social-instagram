package com.reputation.social.instagram.api;

import org.springframework.social.ApiBinding;

public interface Instagram extends ApiBinding {

	CommentOperations commentOperations();

	LikeOperations likeOperations();

	MediaOperations mediaOperations();

	RelationshipOperations relationshipOperations();

	UserOperations userOperations();
}
