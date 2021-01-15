package com.gmail.andrew94;

import com.gmail.andrew94.dao.TransactionDao;
import com.gmail.andrew94.dao.TransactionDaoImpl;
import com.gmail.andrew94.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.*;

/**
 * @author Andrew Samoilov
 */
public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {

        List<Transaction> transactions = XmlWorker.readXml("Java_test.xml", "transaction", Transaction.class);

        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()){

            TransactionDao<Transaction, Long> transactionDao = new TransactionDaoImpl(sessionFactory);

            transactionDao.saveAll(transactions);
        }

    }

}

