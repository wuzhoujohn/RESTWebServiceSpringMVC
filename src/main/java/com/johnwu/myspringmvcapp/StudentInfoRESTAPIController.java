package com.johnwu.myspringmvcapp;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentInfoRESTAPIController {
	//when clients make a call to this method handler, this method 
	//will return all the students that has been using this web application
	//in JSON format.
	//****************retrieve all students records
	@RequestMapping(value = "/studentlist", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Student> getStudentList(){
		//System.out.println("we are in");
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		Student student1 = new Student();
		student1.setStudentName("John Smith");
		
		Student student2 = new Student();
		student2.setStudentName("John October");
		
		Student student3 = new Student();
		student3.setStudentName("Jane Marry");
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		for(int i = 0; i < studentList.size(); i++){
			System.out.println(studentList.get(i).getStudentName());
		}
		//return studentList;
		return studentList;
	}
	
	//******************retrieve a student record****************************
	//GET: clients would issue a get request in some cases when the server has some resources and clients want to read them
	@RequestMapping(value = "/studentlist/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName){
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("Music");
		//return studentList;
		return student;
	}
	
	//****************Update a student record with PUT request*******************
	//the @RequestBody annotation is used to convert to proper java object from either JSON or XML format which is provided by clients
	//PUT: clients would issue a put request in some cases when the server has some certain resources and they want to alter the resources. 
	@RequestMapping(value="/studentlist/{name}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> UpdateStudent(@PathVariable("name") String studentName, @RequestBody Student student){
		System.out.println("Student Name: " + studentName);
		System.out.println("Student Name: " + student.getStudentName() + "Student Hobby: " + student.getStudentHobby());
		//find the matching record using "studentName" from the DB
		//update the matching student record with the information of student sent by the client
		//when only one argument in responseEntity return status 200 if such student was found, or return 404
		//when there are two arguments in responseEntity, the first argument is considered as responseBody, the second argument is considered as response status
		//when there are three arguments in responseEntity, the first is responseBody, the second is httphears, the third is response status
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("key1", "value1");
		httpHeaders.add("key2", "value2");
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);
	}
	
	//POST: clients would issue a post request in the cases when they want to create a new resource at the server
	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student student){
		System.out.println("new student name is " + student.getStudentName() + ", and hobby is " + student.getStudentHobby());
		//insert into database
		HttpHeaders httpHeaders = new HttpHeaders();
		//provide the clients with the url where the newly inserted student record can be reached, which is refer to method getStudent()
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{name}")
									.buildAndExpand(student.getStudentName()).toUri()
									.toString());
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);
	}
	
	//*****************************Delete a student record*********************
	//DELETE: clients would issue a delete request in the cases when they want to delete some resource at the server
	@RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName){
		System.out.println("deleted student name is " + studentName);
		//delete the student from database
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
	
	//*********************Delete all students record*****************************
	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllStudents(){
		//delete all students from database
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
}
