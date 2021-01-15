package com.gmail.andrew94.dao;

import com.gmail.andrew94.XmlWorker;
import com.gmail.andrew94.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Andrew Samoilov
 */
public class TransactionDaoTest {

    private static SessionFactory sessionFactory;
    private Session session;


    @BeforeAll
    public static void setup() throws Exception {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null)
            sessionFactory.close();
    }


    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession() {
        if (session != null)
            session.close();
    }

    @Test
    public void testSaveAll() throws Exception{

        List<Transaction> transactionsFromXml = XmlWorker.readXml("Java_test.xml", "transaction", Transaction.class);

        TransactionDao<Transaction, Long> transactionDao = new TransactionDaoImpl(sessionFactory);

        transactionDao.saveAll(transactionsFromXml);

        List<Transaction> transactionList = session.createQuery("SELECT t FROM Transaction t", Transaction.class)
                .getResultList();

        assertEquals(transactionsFromXml, transactionList);

    }

    @Test
    public void saveOne() throws Exception{
        List<Transaction> transactionsFromXml = XmlWorker.readXml("Java_test.xml", "transaction", Transaction.class);

        Transaction transaction = transactionsFromXml.stream().findAny().get();

        TransactionDao<Transaction, Long> transactionDao = new TransactionDaoImpl(sessionFactory);

        Long id = transactionDao.create(transaction);

        Transaction transactionDb = session.createQuery("SELECT t FROM Transaction t WHERE t.id="+id, Transaction.class)
                .getSingleResult();

        assertEquals(transaction, transactionDb);

    }
}