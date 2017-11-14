package com.felix.dao;

import com.felix.entity.Student;

public class StudentDao extends AbstractDao<Student> {

	public Class<Student> getEntityType() {
		return Student.class;
	}

	@Override
	public Object getPrimaryKey(Student entity) {
		return entity.getId();
	}

	@Override
	public void update(Student entity) {
		Student student = find(entity.getId());
		getEntityManager().getTransaction().begin();
		student.setFirstName(entity.getFirstName());
		student.setLastName(entity.getLastName());
		student.setUsername(entity.getUsername());
		student.setEmail(entity.getEmail());
		getEntityManager().getTransaction().commit();
	}
}
