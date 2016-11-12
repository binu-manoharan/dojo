package client;

import entity.Message;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Application entry point
 */
public class HelloWorld {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Message message = new Message("Welcome to the world of hibernate!");
        session.save(message);

        session.getTransaction().commit();
        session.close();
    }
}
