package com.felix.listener;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class DatabaseInitializer {

	public void initialize() {
		initializeStudents();
	}

	private void initializeStudents() {
		CsvMapper mapper = new CsvMapper();
	}
}
