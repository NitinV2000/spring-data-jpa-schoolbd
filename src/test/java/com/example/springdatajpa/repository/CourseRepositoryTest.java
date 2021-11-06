package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Priya")
				.lastName("S")
				.build();
		
		Course course = Course.builder()
				.title("CAO")
				.credit(3)
				.teacher(teacher)
				.build();
		
		courseRepository.save(course);
	}
	
//	@Test
//	public void printfindByTitleContaining() {
//		PageRequest firstPageTenRecords = PageRequest.of(0, 10);
//		List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
//		
//		System.out.println(courses);
//	}
	
	//write
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("Hari")
				.lastName("RV")
				.build();
		
		Student student = Student.builder()
				.firstName("Jerry")
				.lastName("V")
				.emailId("jerry@gmail.com")
				.build();
		
		Course course = Course.builder()
				.title("AI")
				.credit(4)
				.teacher(teacher)
				.build();
		course.addStudents(student);
		courseRepository.save(course);
	}
	
	@Test
	public void findAllPagination() {
		PageRequest firstPagewithThreeRecords = PageRequest.of(0, 3);
		PageRequest secondPagewithTwoPageable = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepository.findAll(firstPagewithThreeRecords).getContent();
		
		int totalElements = courseRepository.findAll(firstPagewithThreeRecords).getTotalPages();
		
		System.out.println(totalElements);
		
		System.out.println(courses);
	}
	
	@Test
	public void printAllCourses() {
		List<Course> c = courseRepository.findAll();
		System.out.println(c);
	}
}
