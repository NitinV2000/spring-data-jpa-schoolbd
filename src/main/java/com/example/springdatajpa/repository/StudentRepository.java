package com.example.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
