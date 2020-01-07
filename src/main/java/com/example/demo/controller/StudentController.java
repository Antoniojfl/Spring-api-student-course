package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/Students")
public class StudentController {
	
	private StudentService service;
	
	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}
	

	@GetMapping
	@ResponseBody
	public Page<Student> findAll(Pageable pageable){
		return this.service.findAll(pageable);
	}
	
	
	@GetMapping("/all")
	@ResponseBody
	public Iterable<Student> findAll() {
		return this.service.findAll();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
		Student savedStudent = this.service.create(student);

		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Student> delete(@PathVariable(value="id") Integer id){
		this.service.delete(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Student> update(@PathVariable(value = "id") Integer id, @RequestBody Student student){
		Student savedStudent = this.service.update(id, student);
		
		return new ResponseEntity<>(savedStudent, HttpStatus.OK);
	}
	
	@GetMapping("/sp/{saludo}")
	@ResponseBody
	public List <Object[]> saludo(@PathVariable(value = "saludo") String saludo) {
		
		return this.service.sp_student(saludo);
	}
	
	@GetMapping("/cursor/{age}")
	@ResponseBody
	public ResponseEntity<List<?>> getStudentAge(@PathVariable(value = "age")Integer age) {
		
		List <?> result = this.service.sp_course(age);
		 return new ResponseEntity<>(result, HttpStatus.OK);
		 
	}
	
	
	
	

}
