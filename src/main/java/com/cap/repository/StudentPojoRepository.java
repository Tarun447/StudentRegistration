package com.cap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.entity.StudentPojo;


@Repository
public interface StudentPojoRepository extends MongoRepository<StudentPojo, String> {
	@Query("{'email':?0}")
	public StudentPojo findbyEmail(String email);
}
