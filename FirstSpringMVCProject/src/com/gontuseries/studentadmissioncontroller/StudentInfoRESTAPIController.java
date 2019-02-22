package com.gontuseries.studentadmissioncontroller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentInfoRESTAPIController {

//	tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object
//	@ResponseBody - if @controller was use, specify @responsebody
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentsList() {
		Student student1 = new Student();
		student1.setStudentName("The Great Khali");

		Student student2 = new Student();
		student2.setStudentName("The Undertaker");

		Student student3 = new Student();
		student3.setStudentName("John Cena");

		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);

		return studentsList;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("WWE");

		return student;
	}

//	update a student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public boolean updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {
	public  ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName, @RequestBody Student student) {		
		System.out.println("Student Name: " + studentName);
		System.out.println("Student Name: " + student.getStudentName() + " Student Hobby: " + student.getStudentHobby());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("key1", "value1");
		httpHeaders.add("key2", "value2");
		
		return new ResponseEntity<Boolean>(true,  httpHeaders,HttpStatus.OK);
//		return true;
	}
	
//	posting a student record
	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Boolean> postStudent(@RequestBody Student student) {		
		System.out.println("Student Name: " + student.getStudentName() + " Student Hobby: " + student.getStudentHobby());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{name}")
				.buildAndExpand(student.getStudentName())
				.toUri()
				.toString());
		
		return new ResponseEntity<Boolean>(true,httpHeaders,  HttpStatus.OK);
	}
	
//	deleting a student record
	@RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
	public  ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {		
		System.out.println("Student Name: " + studentName);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
//	deleting all student record
	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public  ResponseEntity<Boolean> deleteAllStudent() {		
//		System.out.println("Student Name: " + studentName);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
