package com.jnit.app;


import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.jnit.app.model.Student;


public class JpaConfigurationTest extends ParentTest{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void testIntegration(){
		System.out.println("Everything good");
	}
	
	@Test
	@Transactional
	public void testHibernateSession(){
		Session session = entityManager.unwrap(Session.class);
		Student student = new Student("aparna@gmail.com", "Aparna", "k", "c", "appu12", LocalDate.of(1992, 9, 24));
		session.save(student);
		//session.flush();
		session.getTransaction().commit();
		//User user1 = session.get(User.class, 1L);
		//System.out.println(user1.getfName());
		
	}
}
