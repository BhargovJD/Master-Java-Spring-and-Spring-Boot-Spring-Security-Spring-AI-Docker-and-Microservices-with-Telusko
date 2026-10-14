
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create address object
        Address address = new Address();
        address.setCity("Guwahati");
        address.setState("Assam");

        // Create student object
        Student student = new Student();
        student.setId(1);
        student.setName("Rahul");
        student.setAddress(address);

        try (Session session = factory.openSession()) {

            Transaction tx = session.beginTransaction();

            session.persist(student);

            tx.commit();

            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }
}
