package org.binu.client;

import org.binu.entity.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.binu.util.HibernateUtil;

/**
 * Application entry point
 */
public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Message message = new Message("Welcome to the log4j!");
        session.save(message);

        session.getTransaction().commit();
        session.close();

        logger.info("Bye bye!");
        HibernateUtil.getSessionFactory().close();
    }
}
