package com.reputation.social.instagram.api.impl;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.reputation.social.instagram.api.InstagramProfile;

class InstagramModule extends SimpleModule {

	public InstagramModule() {
		super("InstagramModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(InstagramProfile.class, InstagramProfileMixin.class);
	}
}
