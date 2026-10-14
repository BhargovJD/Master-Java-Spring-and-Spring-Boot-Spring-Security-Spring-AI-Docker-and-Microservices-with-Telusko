
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Configure Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Open session
        try (Session session = factory.openSession()) {

            // Fetch student by ID
            Student student = session.find(Student.class, 1);

            // Check whether student exists
            if (student != null) {

                System.out.println("Student ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());

            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }
}
