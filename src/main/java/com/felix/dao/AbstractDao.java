package com.felix.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public abstract class AbstractDao<T> {

	@Inject
	private Provider<EntityManager> entityManagerProvider;

	protected EntityManager getEntityManager() {
		return entityManagerProvider.get();
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

	@Transactional
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	public T find(Object primaryKey) {
		return getEntityManager().find(getEntityType(), primaryKey);
	}

	public List<T> findAll() {
		String namedQuery = getEntityType().getSimpleName() + ".findAll";
		TypedQuery<T> query = getEntityManager().createNamedQuery(namedQuery, getEntityType());
		return query.getResultList();
	}

	public boolean contains(Object primaryKey) {
		return find(primaryKey) != null;
	}

}
