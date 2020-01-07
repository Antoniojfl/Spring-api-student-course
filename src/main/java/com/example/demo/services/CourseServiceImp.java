package com.example.demo.services;

import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;

@Service
public class CourseServiceImp implements CourseService{
	

	private CourseRepository repository;
	
	public CourseServiceImp(CourseRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public Iterable<Course> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Page<Course> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public Course create(Course course) {
		return this.repository.save(course);
	}

	@Override
	public Course update(Integer id, Course course) {
		Course savedCourse = this.findById(id);
		savedCourse.setName(course.getName());
		
		return this.repository.save(savedCourse);	
		
	}

	@Override
	public void delete(Integer id) {
		Course deleteCourse = this.findById(id);
		this.repository.delete(deleteCourse);
		
	}

	@Override
	public Course findById(Integer id) {
		Optional<Course> possibleCourse = this.repository.findById(id);

        if (!possibleCourse.isPresent()) {
            // throw new TeamNotFoundException();
        }

        return possibleCourse.get();
    }
	

}
