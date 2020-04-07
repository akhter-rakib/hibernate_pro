package com.rakib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.rakib.entity.student.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			Student std = new Student("ali", "Harun", "open@gmail.com");
			Student std2 = new Student("Mafuz", "Harun", "open@gmail.com");
			Student std3 = new Student("Khadiza", "Harun", "open@gmail.com");

			session.beginTransaction();
			session.save(std);
			session.save(std2);
			session.save(std3);
			session.getTransaction().commit();
		} finally {

		}

	}

}
