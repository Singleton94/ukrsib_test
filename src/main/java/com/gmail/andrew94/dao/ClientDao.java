package com.gmail.andrew94.dao;

import org.hibernate.annotations.NamedQuery;

/**
 * @author Andrew Samoilov
 */
public interface ClientDao <Client, Key>{
    void create(Client client);

    Client read(Key key);
}
