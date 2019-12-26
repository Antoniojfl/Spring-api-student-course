package com.example.demo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Course;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {

}