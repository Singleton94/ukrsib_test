package com.gmail.andrew94.dao;

import java.util.List;

/**
 * @author Andrew Samoilov
 */
public interface TransactionDao <Transaction, Key>{
    void saveAll(List<Transaction> transactions);
}
