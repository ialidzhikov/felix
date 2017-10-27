package com.felix.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;
	
	public void persist(T entity) {
		entityManager.persist(entity);
	}
}
