package com.gmail.andrew94.dao;

import com.gmail.andrew94.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Andrew Samoilov
 */
public class TransactionDaoImpl implements TransactionDao<Transaction, Long> {

    private final SessionFactory sessionFactory;

    public TransactionDaoImpl(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public void saveAll(List<Transaction> transactions) {

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            for (Transaction transaction : transactions) {
                session.save(transaction);
            }
            session.flush();
            session.getTransaction().commit();
        }
    }
}
