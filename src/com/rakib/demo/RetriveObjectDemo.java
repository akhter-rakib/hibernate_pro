package com.rakib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rakib.entity.student.Student;

public class RetriveObjectDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student std = new Student("Rakib Hasan", "Hasan", "Test@gmail.com");
			session.beginTransaction();
			session.save(std);
			session.getTransaction().commit();

			// now get a new session and transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Student retriveStudent = session.get(Student.class, std.getId());
			System.out.println("Retrive Student" + retriveStudent.getId());
		} finally {
			session.close();
		}

	}

}
