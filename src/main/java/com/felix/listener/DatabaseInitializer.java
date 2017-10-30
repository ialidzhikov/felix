package com.felix.listener;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class DatabaseInitializer {

	private TopicDao topicDao;
	private StudentDao studentDao;
	private RankingDao rankingDao;

	public DatabaseInitializer() {
		topicDao = new TopicDao();
		studentDao = new StudentDao();
		rankingDao = new RankingDao();
	}

	public void initialize() throws IOException {
		List<Topic> topics = readData("../bin/felix/topics.csv", Topic.class);
		List<Student> students = readData("../bin/felix/students.csv", Student.class);

		persistData(topicDao, topics);
		persistData(studentDao, students);

		List<Ranking> rankings = readRankings("../bin/felix/rankings.csv");
		persistData(rankingDao, rankings); 
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
