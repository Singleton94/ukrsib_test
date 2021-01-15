package com.gmail.andrew94.dao;

import org.hibernate.annotations.NamedQuery;

import java.util.List;

/**
 * @author Andrew Samoilov
 */
public interface ClientDao <Client, Key>{
    void create(Client client);
    void saveAll(List<Client> clients);
    Client read(Key key);
    List<Client> findAll();
}
