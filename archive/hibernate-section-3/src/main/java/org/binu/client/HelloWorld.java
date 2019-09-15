package org.binu.client;

import org.binu.entity.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.binu.util.HibernateUtil;
import org.hibernate.Transaction;

/**
 * Application entry point
 */
public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        final Transaction transaction = session.getTransaction();
        transaction.begin();

        Message message = (Message) session.get(Message.class, 1L);
        final String oldText = message.getText();
        final String updatedText =  oldText + " зрасти!";
        message.setText(updatedText);

        final Message messageToDelete = (Message) session.get(Message.class, 18L);
        session.delete(messageToDelete);

        transaction.commit();
        session.close();

        logger.info("Bye bye!");
        HibernateUtil.getSessionFactory().close();
    }
}
