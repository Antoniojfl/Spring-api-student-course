package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.Course;

public interface CourseService {
	
	Iterable<Course> findAll();
	
	Page<Course> findAll(Pageable pageable);
	
	Course create(Course course);
	
	Course update(Integer id, Course course);
	
	void delete(Integer id);
	
	Course findById(Integer id);
	
	
}
