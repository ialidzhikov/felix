package com.felix.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// Empty body
	}
}
