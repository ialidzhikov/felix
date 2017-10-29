package com.felix.entity;

import java.util.List;

public class LeaderboardRecord implements Comparable<LeaderboardRecord> {

	private int rank;
	private String firstName;
	private String lastName;
	private List<Ranking> rankings;
	private int total;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Ranking> getRankings() {
		return rankings;
	}

	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public int compareTo(LeaderboardRecord other) {
		return Integer.compare(this.getTotal(), other.total);
	}
}
