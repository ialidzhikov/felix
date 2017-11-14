package com.felix.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class DataSourceModule extends AbstractModule {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceModule.class);

	private static final String DEBUG_CONFIGURING_MODULE_MESSAGE = "Configuring DataSourceModule";

	private static final String PERSISTENCE_UNIT = "felix";

	@Override
	protected void configure() {
		logger.debug(DEBUG_CONFIGURING_MODULE_MESSAGE);

		install(new JpaPersistModule(PERSISTENCE_UNIT));
	}
}
