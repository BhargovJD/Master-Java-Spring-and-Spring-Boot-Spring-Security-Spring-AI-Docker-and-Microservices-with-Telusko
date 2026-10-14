package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create first student
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Rahul");

        // Create second student
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Amit");

        // Create first course
        Course c1 = new Course();
        c1.setId(101);
        c1.setName("Java");

        // Create second course
        Course c2 = new Course();
        c2.setId(102);
        c2.setName("Python");

        // Assign courses to students
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        s2.getCourses().add(c1);
        s2.getCourses().add(c2);

        // Save all entities
        session.persist(c1);
        session.persist(c2);
        session.persist(s1);
        session.persist(s2);

        tx.commit();

        session.close();
        factory.close();
    }
}