
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
                .addAnnotatedClass(Alien.class)
                .buildSessionFactory();

        // Create Alien object
        Alien alien = new Alien();
        alien.setAid(1);
        alien.setAname("Rahul");
        alien.setTech("Java");

        // Open session
        try (Session session = factory.openSession()) {

            // Start transaction
            Transaction tx = session.beginTransaction();

            // Insert alien data
            session.persist(alien);

            // Commit transaction
            tx.commit();

            System.out.println("Alien inserted successfully!");
            System.out.println(alien);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }
}
