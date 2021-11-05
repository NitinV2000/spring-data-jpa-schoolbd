package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("nitin@gmail.com")
				.firstName("Nitin")
				.lastName("V")
				//.guardianName("Tintin")
				//.guardianEmail("tintin@gmail.com")
				//.guardianMobile("1234567890")
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.email("tintin@gmail.com")
				.name("Tintin")
				.mobile("1234567890")
				.build();
		
		Student student = Student.builder()
				.firstName("Tom")
				.lastName("V")
				.emailId("tom@gmail.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}
}
