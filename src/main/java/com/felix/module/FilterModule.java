package com.felix.module;

import com.felix.filter.PersistFilter;
import com.google.inject.servlet.ServletModule;

public class FilterModule extends ServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		filter("/*").through(PersistFilter.class);
	}
}
