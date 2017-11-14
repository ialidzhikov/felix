package com.felix.resource;

import java.util.Set;

import javax.ws.rs.core.Application;

import com.felix.listener.ApplicationContextListener;

public class Felix extends Application {

	@Override
	public Set<Object> getSingletons() {
		return ApplicationContextListener.getSingletons();
	}
}
