package com.felix.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felix.entity.LeaderboardRecord;
import com.felix.service.LeaderboardService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("leaderboard")
public class LeaderboardResource {

	@Inject
	private LeaderboardService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LeaderboardRecord> get() {
		return service.get();
	}
}
