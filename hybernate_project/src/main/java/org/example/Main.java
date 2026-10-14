
package org.example;
// Defines the package where this class belongs.

import org.hibernate.Session;
// Imports Session, which is used to interact with the database.

import org.hibernate.SessionFactory;
// Imports SessionFactory, which creates database sessions.

import org.hibernate.Transaction;
// Imports Transaction, which manages database transactions.

import org.hibernate.cfg.Configuration;
// Imports Configuration, which loads Hibernate settings.

public class Main {
// Defines a class named Main.

    public static void main(String[] args) {
        // The main method is the starting point of the Java program.

        SessionFactory factory = new Configuration()
                // Creates a Hibernate configuration object.

                .configure("hibernate.cfg.xml")
                // Loads database settings from hibernate.cfg.xml.

                .addAnnotatedClass(Student.class)
                // Registers the Student entity with Hibernate.

                .buildSessionFactory();
        // Builds the SessionFactory using these settings.

        Student student = new Student();
        // Creates a new Student object in Java memory.

        student.setName("Rahul");
        // Sets the student's name to Rahul.

        student.setAge(22);
        // Sets the student's age to 22.

        try (Session session = factory.openSession()) {
            // Opens a database session.
            // try-with-resources automatically closes the session.

            Transaction transaction = session.beginTransaction();
            // Starts a database transaction.

            session.persist(student);
            // Tells Hibernate to save the Student object.

            transaction.commit();
            // Commits the transaction so the insert can be saved.

            System.out.println("Student saved successfully!");
            // Prints a success message.

            System.out.println("Student ID: " + student.getId());
            // Prints the student's ID, if generated and assigned.

        } catch (Exception e) {
            // Handles errors that occur inside the try block.

            e.printStackTrace();
            // Prints error details to help find the problem.

        } finally {
            // This block runs whether an exception occurs or not.

            factory.close();
            // Closes the SessionFactory and releases its resources.
        }
    }
}
