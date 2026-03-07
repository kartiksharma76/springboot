package com.demo.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "enrollment_no")
	private String enrollmentNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "branch")
	private String branch;

	@Column(name = "year")
	private String year;

	@Column(name = "dob")
	private String dob;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "mobile_no")
	private String mobileNumber;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "father_mobile")
	private String fatherMobileNumber;

	@Column(name = "room_id")
	private String roomId;

	@Column(name = "password")
	private String password;
}
