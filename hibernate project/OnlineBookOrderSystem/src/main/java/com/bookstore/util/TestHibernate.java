package com.bookstore.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        
        if (session != null) {
            System.out.println("✅ Hibernate Connection Successful!");
        } else {
            System.out.println("❌ Hibernate Connection Failed!");
        }

        session.close();
        factory.close();
    }
}
