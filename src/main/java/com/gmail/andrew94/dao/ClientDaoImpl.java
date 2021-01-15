package com.gmail.andrew94.dao;

import com.gmail.andrew94.entity.Client;
import com.gmail.andrew94.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Andrew Samoilov
 */
public class ClientDaoImpl implements ClientDao<Client, Long> {

    private final SessionFactory sessionFactory;

    public ClientDaoImpl(SessionFactory factory) {
        this.sessionFactory = factory;
    }


    @Override
    public void create(Client client) {
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            session.save(client);

            session.getTransaction().commit();
        }
    }

    @Override
    public void saveAll(List<Client> clients) {
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            for (Client client : clients)
                session.saveOrUpdate(client);

            session.getTransaction().commit();
        }
    }


    @Override
    public Client read(Long id) {
        try ( Session session = sessionFactory.openSession()) {

            Client result = session.get(Client.class, id);

            return result != null ? result : new Client();
        }
    }

    @Override
    public List<Client> findAll() {
        try ( Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        }
    }
}
