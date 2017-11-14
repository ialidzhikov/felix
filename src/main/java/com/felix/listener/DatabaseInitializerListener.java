package com.felix.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseInitializerListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			DatabaseInitializer initializer = ApplicationContextListener.getStaticInjector()
					.getInstance(DatabaseInitializer.class);
			initializer.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Empty body
	}
}
