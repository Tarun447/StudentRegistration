package com.cap.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class StudentPojo {
	
	@Id
	private String id;
	
	private String name;
	
	private Integer age;
	
	@Indexed(unique = true)
	private String email;
	
	private Long phone;
	
	private String gender;
	
	private String address;
	


	public StudentPojo(String name, Integer age, String email, Long phone, String gender, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
	}
	
	

}
