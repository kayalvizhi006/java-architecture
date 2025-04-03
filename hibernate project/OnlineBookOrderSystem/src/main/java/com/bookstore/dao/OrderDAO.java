package com.bookstore.dao;

import com.bookstore.model.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bookstore.util.HibernateUtil;

public class OrderDAO {

    public void saveOrder(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            System.out.println("✅ Order saved successfully!");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
