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
                .addAnnotatedClass(IDCard.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setId(1);
        student.setName("Rahul");

        IDCard card = new IDCard();
        card.setId(101);
        card.setCardNumber("CARD101");

        // Connect both objects
        student.setCard(card);
        card.setStudent(student);

        // Save both objects
        session.persist(student);
        session.persist(card);

        tx.commit();

        session.close();
        factory.close();
    }
}