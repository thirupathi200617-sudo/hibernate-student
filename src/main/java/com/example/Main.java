package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();

            Student student = new Student(
                    2,
                    "Thirupathi",
                    "thirupathi@gmail.com",
                    "AI & DS"
            );

            session.persist(student);

            session.getTransaction().commit();

            System.out.println("Student inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}