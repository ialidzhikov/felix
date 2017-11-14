package com.felix.resource;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felix.dao.TopicDao;
import com.felix.entity.Topic;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("topics")
public class TopicResource {

	@Inject
	private TopicDao dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Topic> getAll() {
		return dao.findAll();
	}
}
