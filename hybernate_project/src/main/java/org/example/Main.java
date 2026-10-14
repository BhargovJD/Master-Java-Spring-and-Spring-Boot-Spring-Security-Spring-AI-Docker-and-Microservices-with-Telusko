package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Create department
        Department department = new Department();
        department.setId(1);
        department.setName("IT");

        // Create first employee
        Employee e1 = new Employee();
        e1.setId(101);
        e1.setName("Rahul");
        e1.setDepartment(department);

        // Create second employee
        Employee e2 = new Employee();
        e2.setId(102);
        e2.setName("Amit");
        e2.setDepartment(department);

        // Save all three objects
        session.persist(department);
        session.persist(e1);
        session.persist(e2);

        tx.commit();

        session.close();
        factory.close();
    }
}