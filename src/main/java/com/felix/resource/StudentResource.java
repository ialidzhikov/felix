package com.felix.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felix.dao.StudentDao;
import com.felix.entity.Student;

@Path("students")
public class StudentResource {

	private StudentDao dao;

	public StudentResource() {
		this.dao = new StudentDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAll() {
		return dao.findAll();
	}
}
