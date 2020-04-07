package com.rakib.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.student.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Student> std = session.createQuery("from Student").list();
			// display all the student
			for (Student student : std) {
				System.out.println(student.toString());
			}
			// Query student Last name
			List<Student> stdLastName = session.createQuery("from Student s where s.lastName = 'Harun'").list();
			System.out.println(stdLastName.toString());
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

}
