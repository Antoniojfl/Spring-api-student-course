package com.example.demo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {

}
