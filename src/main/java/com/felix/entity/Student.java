package com.felix.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@NamedQueries(@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"))
@JsonPropertyOrder({ "id", "firstName", "lastName", "facultyNumber", "username", "email" })
public class Student {

	@Id
	private Long id;

	@Column(name = "FIRST_NAME", length = 128, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", length = 128, nullable = false)
	private String lastName;

	@Column(name = "FACULTY_NUMBER", length = 20, nullable = false, unique = true)
	private String facultyNumber;

	private String username;

	private String email;

	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@OrderBy("id ASC")
	private List<Ranking> rankings = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Ranking> getRankings() {
		return rankings;
	}

	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}
}
