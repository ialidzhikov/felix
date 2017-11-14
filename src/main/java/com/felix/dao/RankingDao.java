package com.felix.dao;

import com.felix.entity.Ranking;

public class RankingDao extends AbstractDao<Ranking> {

	@Override
	public Class<Ranking> getEntityType() {
		return Ranking.class;
	}

	@Override
	public Object getPrimaryKey(Ranking entity) {
		return entity.getId();
	}

	@Override
	public void update(Ranking entity) {
		Ranking ranking = find(getPrimaryKey(entity));
		getEntityManager().getTransaction().begin();
		ranking.setTopic(entity.getTopic());
		ranking.setStudent(entity.getStudent());
		ranking.setPoints(entity.getPoints());
		getEntityManager().getTransaction().commit();
	}
}
