package com.felix.dao;

import com.felix.entity.Topic;

public class TopicDao extends AbstractDao<Topic> {

	@Override
	public Class<Topic> getEntityType() {
		return Topic.class;
	}

	@Override
	public Object getPrimaryKey(Topic entity) {
		return entity.getId();
	}

	@Override
	public void update(Topic entity) {
		Topic topic = find(entity.getId());
		getEntityManager().getTransaction().begin();
		topic.setName(entity.getName());
		topic.setMaxPoints(entity.getMaxPoints());
		getEntityManager().getTransaction().commit();
	}
}
