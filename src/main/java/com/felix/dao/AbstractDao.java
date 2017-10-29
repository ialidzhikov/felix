package com.felix.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class AbstractDao<T> {

	protected EntityManager entityManager;

	public AbstractDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("felix");
		entityManager = factory.createEntityManager();
	}

	public abstract Class<T> getEntityType();

	public abstract Object getPrimaryKey(T entity);

	public abstract void update(T entity);

	public void save(T entity) {
		if (contains(getPrimaryKey(entity))) {
			update(entity);
		} else {
			persist(entity);
		}
	}

	public void persist(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public T find(Object primaryKey) {
		return entityManager.find(getEntityType(), primaryKey);
	}

	public List<T> findAll() {
		String namedQuery = getEntityType().getSimpleName() + ".findAll";
		TypedQuery<T> query = entityManager.createNamedQuery(namedQuery, getEntityType());
		return query.getResultList();
	}

	public boolean contains(Object primaryKey) {
		return find(primaryKey) != null;
	}

}
