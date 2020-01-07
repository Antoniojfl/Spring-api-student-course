package com.example.demo.services;

import java.util.List;

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
	
	List <Object[]> sp_student(String saludo);
	
	List<?> sp_course(Integer age);
	

}
