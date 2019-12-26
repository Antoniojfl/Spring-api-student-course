package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.Student;

public interface StudentService {
	
	Iterable<Student> findAll();
	
	Student create(Student student);
	
	Page<Student> findAll(Pageable pageable);
	
	void delete(Integer id);
	
	Student update(Integer id, Student student);
	
	Student findById(Integer id);
	

}
