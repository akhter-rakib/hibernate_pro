package com.rakib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.student.Student;

public class CreateStudentDemo {
	
  public static void main(String[] args) {
 SessionFactory factory = new Configuration()
			 .configure().addAnnotatedClass(Student.class)
			 .buildSessionFactory();
	Session session = factory.getCurrentSession();
	try {
		//creating Student obj
		Student student = new Student("rakib", "bepari","akter@gmail.com");
		//start a transaction
		session.beginTransaction();
		//save the student obj
		session.save(student);
		//commit transaction
		session.getTransaction().commit();
		System.out.println("Save Done Successfully");
		
	}finally {
		factory.close();
	}
  }

}
