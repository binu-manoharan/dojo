package org.binu.client;

import org.binu.scores.PlayerScore;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.binu.util.HibernateUtil;

/**
 * Application entry point
 */
public class FizzBuzzTest {

    private static final Logger logger = LogManager.getLogger(FizzBuzzTest.class);

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        PlayerScore playerScore = new PlayerScore("Binu", 10);
        session.save(playerScore);

        session.getTransaction().commit();
        session.close();

        logger.info("Bye bye!");
        HibernateUtil.getSessionFactory().close();
    }
}
