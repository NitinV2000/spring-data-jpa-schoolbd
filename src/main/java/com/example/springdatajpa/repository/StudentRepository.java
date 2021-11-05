package com.example.springdatajpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByGuardianName(String guardianName);
	
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentByEmailAddress(String emailId);
	
	@Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailId);
	
	@Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
	int updateStudentNameByEmailId(String firstName,String emailId);
}
