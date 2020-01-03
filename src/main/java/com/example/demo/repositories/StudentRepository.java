package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Student;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
	//@Procedure(name = "sp_student")
	//List <Object[]> sp_student(@Param("saludo") String saludo);
	
	@Query(value = "select antonio.sp_student(:saludo)", nativeQuery = true)
    public List<Object[]> sp_student(@Param("saludo") String saludo);
    
    @Query(value = "begin; select antonio.sp_cursor(:mycursor, :age); fetch all in \"mycursor\"", nativeQuery = true)
    public List<Object[]> sp_cursor(@Param("mycursor") String cursor, @Param("age") Integer age);

    
}
