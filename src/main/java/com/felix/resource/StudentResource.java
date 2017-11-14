package com.felix.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felix.dao.StudentDao;
import com.felix.entity.Student;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("students")
public class StudentResource {

	@Inject
	private StudentDao dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAll() {
		return dao.findAll();
	}
}
