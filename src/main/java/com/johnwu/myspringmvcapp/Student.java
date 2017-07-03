package com.johnwu.myspringmvcapp;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//this only includes not null values
@JsonInclude(JsonInclude.Include.NON_NULL)
//this will remove the properties specified in the argument list
@JsonIgnoreProperties({"studentSkills ", "studentAddress"})
//this organizes the displaying order of the properties
@JsonPropertyOrder({"studentDOB", "student_name", "studentMobile", "studentAddress", "studentHobby", "studentSkills"})
public class Student{
	
	
	//for all the annotations error messages, developers could
	//1.create a file under WEB-INF, in this case, studentmessages.properties
	//2.write statement based on the annotation, for example, for @Size annotation
	//developers should write Size.student1.studentHobby = size of {0} should be between {2} and {1}
	//3. register the file created in the servlet-context file by creating a bean
	//@Pattern performs the same as regular expression, @JsonProperty renames the  property
	@Pattern(regexp="[^0-9]*") @JsonProperty("student_name")
	private String studentName;
	@Size(min=2, max=30) @IsValidHobby(listOfValidHobbies="Music|Football|Hockey")
	private String studentHobby;
	@Max(648000000)
	private Long studentMobile;
	@Past
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Address studentAddress;
	
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
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
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	
	
}
