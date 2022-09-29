package com.cap.service;

import java.util.List;

import com.cap.entity.StudentPojo;

public interface StudentPojoService {
	
	public StudentPojo create(StudentPojo student);
	
	public StudentPojo getEmail(String email);
	
	public StudentPojo getId(String id);
	
	public List<StudentPojo> getAll();
	
	public StudentPojo update(String id,StudentPojo student);
	
	public String delete(String id);
	
	
	

}
