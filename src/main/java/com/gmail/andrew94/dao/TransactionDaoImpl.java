package com.gmail.andrew94.dao;

import com.gmail.andrew94.entity.Client;
import com.gmail.andrew94.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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

            for (Transaction transaction : transactions)
                session.saveOrUpdate(transaction);

            session.getTransaction().commit();
        }
    }


    public Long create(Transaction transaction) {

        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            Serializable serializable = session.save(transaction);

            session.getTransaction().commit();

            return (Long) serializable;
        }
    }

    @Override
    public Optional<Transaction> read(Long id) {
        try (Session session = sessionFactory.openSession()) {

            Transaction result = session.get(Transaction.class, id);

            return Optional.of(result);
        }
    }


}


//    @Override
//    public void create(Client client) {
//        try (Session session = sessionFactory.openSession()) {
//
//            session.beginTransaction();
//
//            session.save(client);
//
//            session.getTransaction().commit();
//        }
//    }
//}
//    @Override
//    public void saveAll(List<Client> clients) {
//        try (Session session = sessionFactory.openSession()) {
//
//            session.beginTransaction();
//
//            for (Client client : clients)
//                session.saveOrUpdate(client);
//
//            session.getTransaction().commit();
//        }
//    }
//
//
//    @Override
//    public Client read(Long id) {
//        try ( Session session = sessionFactory.openSession()) {
//
//            Client result = session.get(Client.class, id);
//
//            return result != null ? result : new Client();
//        }
//    }
//
//
//    @Override
//    public List<Client> findAll() {
//        try ( Session session = sessionFactory.openSession()) {
//            return session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
//        }
//    }
