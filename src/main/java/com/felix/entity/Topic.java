package com.felix.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@NamedQueries(@NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t ORDER BY t.id"))
@JsonPropertyOrder({ "id", "name", "maxPoints" })
public class Topic {

	@Id
	private Long id;

	private String name;

	private int maxPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
}
