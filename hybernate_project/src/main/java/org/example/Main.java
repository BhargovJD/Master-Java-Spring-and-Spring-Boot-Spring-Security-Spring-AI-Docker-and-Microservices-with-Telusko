
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

            // Start transaction
            Transaction tx = session.beginTransaction();

            // Fetch student by ID
            Student student = session.find(Student.class, 1);

            if (student != null) {

                // Delete student
                session.remove(student);

                // Commit transaction
                tx.commit();

                System.out.println("Student deleted successfully!");

            } else {
                tx.rollback();
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }
}
