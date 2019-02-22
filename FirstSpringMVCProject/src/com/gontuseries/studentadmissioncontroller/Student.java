package com.gontuseries.studentadmissioncontroller;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"studentSkills", "studentAddress"})
@JsonPropertyOrder({"studentDOB", "student_name", "studentMobile", "studentAddress", "studentHobby","studentSkills"})
public class Student {
//	@Pattern(regexp="[^0-9]*")
	@JsonProperty("student_name")
	private String studentName;

//	Form Validations - should import hibernate validator jars
//	@Size(min = 2, max = 30, message = "please enter a value for studentHobby field between {min} and {max} characters.")
//	studentmessages.properties
//	placeholder {0} name of field. placeholders {1}, {2}... spring mvc uses alphabetical order to decide which comes first
//	max goes first before min
//	@isvalidhobby custom annotation
	@Size(min = 2, max = 30) @IsValidHobby
	private String studentHobby;

//	@Max(2222)
	private Long studentMobile;
	
	@Past
	private Date studentDOB;
	private List<String> studentSkills;

	private Address studentAddress;

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public List<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(List<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
}
