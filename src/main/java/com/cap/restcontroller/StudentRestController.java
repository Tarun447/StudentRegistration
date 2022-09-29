package com.cap.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.entity.StudentPojo;
import com.cap.service.StudentPojoServiceImpl;



@RequestMapping("/v1/student")
@RestController
public class StudentRestController {
	
	@Autowired
	private StudentPojoServiceImpl service;
	
	
	
	@ResponseBody
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody(required = true) StudentPojo student){
		return new ResponseEntity<>(service.create(student),HttpStatus.CREATED);
	}
	
	
	@ResponseBody
	@GetMapping("/getStudents")
	public ResponseEntity<?> getAll()
	{
		return new ResponseEntity<List<StudentPojo>>(service.getAll(),HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/getStudent/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable String email)
	{
		return new ResponseEntity<StudentPojo>(service.getEmail(email),HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/getStudentId/{id}")
	public ResponseEntity<?> getById(@PathVariable String id)
	{
		return new ResponseEntity<StudentPojo>(service.getId(id),HttpStatus.OK);
	}
	
	
	@ResponseBody
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateById(@PathVariable String id,@RequestBody(required = true) StudentPojo student)
	{
		return new ResponseEntity<StudentPojo>(service.update(id, student),HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id)
	{
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}
	
	

}
