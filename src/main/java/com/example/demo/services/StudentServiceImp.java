package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	private StudentRepository repository;
	
	public StudentServiceImp(StudentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public Student create(Student student) {
		return repository.save(student);
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Student update(Integer id, Student student) {
		Student savedStudent = this.findById(id);
		savedStudent.setName(student.getName());
		savedStudent.setLastName(student.getLastName());
		savedStudent.setAge(student.getAge());
		savedStudent.setRut(student.getRut());
		return this.create(savedStudent);
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> optionalStudent = this.repository.findById(id);
		if(!optionalStudent.isPresent()) {
			
		}
		return optionalStudent.get();
	}

	@Override
	public List<Object[]> sp_student(String saludo) {
		return repository.sp_student(saludo);
	}

	@Override
	public List<Object[]> sp_student(String cursor, Integer age) {
		return repository.sp_cursor(cursor, age);
	}

}
