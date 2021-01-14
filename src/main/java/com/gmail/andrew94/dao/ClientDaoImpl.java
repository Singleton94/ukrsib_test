package com.gmail.andrew94.dao;

import com.gmail.andrew94.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    public Client read(Long id) {
        try ( Session session = sessionFactory.openSession()) {

            Client result = session.get(Client.class, id);

            return result != null ? result : new Client();
        }
    }
}
