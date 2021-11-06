package com.example.springdatajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
