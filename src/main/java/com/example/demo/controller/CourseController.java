package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.example.demo.models.Course;
import com.example.demo.services.CourseService;

@RestController
@RequestMapping("/Courses")
public class CourseController {
	
	private CourseService service;
	
	@Autowired
	public CourseController(CourseService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseBody
	public Page<Course> findAll(Pageable pageable){
		return this.service.findAll(pageable);
	}
	
	@GetMapping("/all") 
	@ResponseBody
	public Iterable<Course> findAll() {
		return this.service.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Course> create(@Valid @RequestBody Course course) {
		Course savedCourse = this.service.create(course);

		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Course> delete(@PathVariable(value="id") Integer id){
		this.service.delete(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Course> update(@PathVariable(value = "id") Integer id, @RequestBody Course course){
		Course savedCourse = this.service.update(id, course);
		
		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
	}
	
	
	
	
	
	
	

}
