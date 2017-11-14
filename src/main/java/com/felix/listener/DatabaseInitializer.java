package com.felix.listener;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.felix.dao.AbstractDao;
import com.felix.dao.RankingDao;
import com.felix.dao.StudentDao;
import com.felix.dao.TopicDao;
import com.felix.entity.Ranking;
import com.felix.entity.Student;
import com.felix.entity.Topic;
import com.google.inject.Inject;

public class DatabaseInitializer {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

	@Inject
	private TopicDao topicDao;

	@Inject
	private StudentDao studentDao;

	@Inject
	private RankingDao rankingDao;

	public void initialize() throws IOException {
		List<Topic> topics = readData("/felix/topics.csv", Topic.class);
		List<Student> students = readData("/felix/students.csv", Student.class);

		persistData(topicDao, topics);
		persistData(studentDao, students);

		List<Ranking> rankings = readRankings("/felix/rankings.csv");
		persistData(rankingDao, rankings);

		logger.info("Database successfully initialized.");
	}

	private <T> void persistData(AbstractDao<T> dao, List<T> entities) {
		for (T entity : entities) {
			dao.save(entity);
		}
	}

	private List<Ranking> readRankings(String path) throws IOException {
		List<Ranking> rankings = readData(path, Ranking.class);
		for (Ranking ranking : rankings) {
			Topic topic = topicDao.find(ranking.getTopicId());
			Student student = studentDao.find(ranking.getStudentId());

			ranking.setTopic(topic);
			ranking.setStudent(student);

			student.getRankings().add(ranking);
		}

		return rankings;
	}

	private <T> List<T> readData(String path, Class<T> clazz) throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(clazz).withHeader().withComments();
		File csvFile = new File(path);

		ObjectReader reader = mapper.readerFor(clazz).with(schema);
		MappingIterator<T> iterator = reader.readValues(csvFile);
		return iterator.readAll();
	}
}
