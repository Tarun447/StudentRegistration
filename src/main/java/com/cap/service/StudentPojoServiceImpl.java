package com.cap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.entity.StudentPojo;
import com.cap.repository.StudentPojoRepository;


@Service
public class StudentPojoServiceImpl implements StudentPojoService {
	
	
	@Autowired
	private StudentPojoRepository repo;

	@Override
	public StudentPojo create(StudentPojo student) {
		
		return repo.save(student);
	}

	@Override
	public StudentPojo getEmail(String email) {
		
		return repo.findbyEmail(email);
	}

	@Override
	public StudentPojo getId(String id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<StudentPojo> getAll() {
		
		return repo.findAll();
	}

	@Override
	public StudentPojo update(String id, StudentPojo student) {
		
		StudentPojo stu = repo.findById(id).get();
		if(stu!=null)
		{
			stu.setId(student.getId());
			stu.setName(student.getName());
			stu.setAge(student.getAge());
			stu.setEmail(student.getEmail());
			stu.setPhone(student.getPhone());
			stu.setGender(student.getGender());
			stu.setAddress(student.getAddress());
		}
		
		return repo.save(stu);
	}

	@Override
	public String delete(String id) {
		repo.deleteById(id);
		
		return "Record has been Deleted with id : "+id;
	}

}
