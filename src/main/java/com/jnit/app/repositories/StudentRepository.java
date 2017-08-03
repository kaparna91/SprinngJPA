package com.jnit.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//Relly -
import com.jnit.app.model.Student;
//find…By, read…By, query…By, count…By, and get…By.

public interface StudentRepository extends JpaRepository<Student, Long>{

	public Optional<Student> findByStudentName(String StudentName);
	
	public List<Student>findByLName(String lastName);

	public Long countByLName(String lastName);

	public Optional<Student>findByFNameAndLName(String FirstName, String lastName);

	public List<Student>findByFNameOrLName(String FirstName, String lastName);
	
	public List<Student>findDistinctByMName(String middleName);

	public List<Student> findFirst3ByLNameOrderByStudentNameAsc(String lastName);

}
