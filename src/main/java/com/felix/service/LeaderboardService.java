package com.felix.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.felix.dao.StudentDao;
import com.felix.entity.LeaderboardRecord;
import com.felix.entity.Ranking;
import com.felix.entity.Student;
import com.google.inject.Inject;

public class LeaderboardService {

	@Inject
	private StudentDao studentDao;

	public List<LeaderboardRecord> get() {
		List<Student> students = studentDao.findAll();

		List<LeaderboardRecord> records = mapToLeaderboardRecord(students);
		Collections.sort(records, Comparator.reverseOrder());
		setRanks(records);

		return records;
	}

	private void setRanks(List<LeaderboardRecord> records) {
		if (records.isEmpty()) {
			return;
		}

		int rank = 1;
		int offset = 0;
		records.get(0).setRank(rank);
		for (int i = 1; i < records.size(); i++) {
			if (records.get(i - 1).getTotal() == records.get(i).getTotal()) {
				offset++;
			} else {
				rank += offset;
				rank++;
				offset = 0;
			}

			records.get(i).setRank(rank);
		}
	}

	private List<LeaderboardRecord> mapToLeaderboardRecord(List<Student> students) {
		List<LeaderboardRecord> records = new ArrayList<>();
		for (Student student : students) {
			LeaderboardRecord leaderboard = new LeaderboardRecord();
			leaderboard.setFirstName(student.getFirstName());
			leaderboard.setLastName(student.getLastName());
			leaderboard.setRankings(student.getRankings());

			int total = 0;
			for (Ranking ranking : student.getRankings()) {
				total += ranking.getPoints();
			}
			leaderboard.setTotal(total);

			records.add(leaderboard);
		}

		return records;
	}
}
