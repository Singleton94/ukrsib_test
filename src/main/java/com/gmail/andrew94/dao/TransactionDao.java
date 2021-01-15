package com.gmail.andrew94.dao;

import com.gmail.andrew94.entity.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrew Samoilov
 */
public interface TransactionDao<Transaction, Key> {
    void saveAll(List<Transaction> transactions);

    Key create(Transaction transaction);

    Optional<Transaction> read(Key id);
}
