package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
		
		Course course1 = Course.builder()
				.title("DBMS")
				.credit(4)
				.build();
		
		Course course2 = Course.builder()
				.title("Java")
				.credit(4)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Nitu")
				.lastName("Sharma")
//				.courses(List.of(course1,course2))
				.build();
		
		teacherRepository.save(teacher);
	}
	

}
