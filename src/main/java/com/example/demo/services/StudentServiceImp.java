package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{

	private EntityManager entityManager;
	private StudentRepository repository;

	
	public StudentServiceImp(StudentRepository repository, EntityManager entityManager) {
		this.repository = repository;
		this.entityManager = entityManager;
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
	@Transactional
	public List<?> sp_course(Integer age){
				 StoredProcedureQuery query = entityManager
				.createStoredProcedureQuery("antonio.sp_cursor")
				.registerStoredProcedureParameter(1,void.class,ParameterMode.REF_CURSOR)
				.registerStoredProcedureParameter(2,Integer.class,ParameterMode.IN)
				.setParameter(2, age);
				 
		List<?> postComments = query.getResultList();
			System.out.print(postComments);
			return postComments;
	}
	

}
