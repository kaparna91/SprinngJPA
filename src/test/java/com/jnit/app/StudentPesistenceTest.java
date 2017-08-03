package com.jnit.app;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

import com.jnit.app.model.Student;

import com.jnit.app.repositories.StudentRepository;

public class StudentPesistenceTest extends ParentTest{

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void teststudentCreation(){
		Student student = new Student("aparna@gmail.com","Aparna", "k", "c", "appu12", LocalDate.of(1992, 9, 24));
		Student createdStudent = studentRepository.save(student);
		assertNotNull("student id not present",createdStudent.getStudentName());
	}

	@Test
	public void testFindStudentById(){
		Student student = studentRepository.findOne(1L);
		assertNotNull("student name not present",student.getStudentName());
	}
	
	@Test
	public void testFindAll(){
		List<Student>students = studentRepository.findAll();
		assertTrue( "students list is empty",students.size() > 0);
	}
	
	@Test
	public void testUpdatestudent(){
		Student student = studentRepository.findOne(1L);
		student.setmName("c");
		Student updatedstudent = studentRepository.save(student);
		assertEquals("c", updatedstudent.getmName());
	}
	
	//@Test
	public void testDeletestudent(){
		Student student = studentRepository.findOne(1L);
		studentRepository.delete(student);
		Student studentObj = studentRepository.findOne(1L);
		assertNull("student seems to be not deleted",studentObj);
	}
	
	@Test
	public void testFindstudentBystudentName(){
		Optional<Student> studentOptional = studentRepository.findByStudentName("aparna@gmail.com");
		assertTrue("student not found with the student name",studentOptional.isPresent());
	}
	
	@Test
	public void testFindByLastName(){
		List<Student>students = studentRepository.findByLName("Aparna");
		assertTrue( "students list is empty",students.size() > 0);
	}

	@Test
	public void testCountByLastName(){
		Long count = studentRepository.countByLName("k");
		assertTrue( "students list is empty",count > 0);
	}
	
	@Test
	public void testFindByFNameAndLName(){
		Optional<Student> studentOptional = studentRepository.findByFNameAndLName("Aparna","k");
		assertTrue("student not found with the provided first and lname",studentOptional.isPresent());
	}

	@Test
	public void testFindByFNameOrLName(){
		List<Student> students = studentRepository.findByFNameOrLName("Aparna","k");
		assertTrue( "students list is empty",students.size() > 0);
	}
	
	@Test
	public void testFindDistinctByMName(){
		List<Student> students = studentRepository.findDistinctByMName("c");
		assertTrue( "students list is empty",students.size() > 0);	
	}
	
	@Test
	public void testFindFirst3ByLNameOrderBystudentNameAsc(){
		List<Student> students = studentRepository.findFirst3ByLNameOrderByStudentNameAsc("k");
		assertTrue( "students list is empty",students.size() > 0);		
	}
	
	

}

