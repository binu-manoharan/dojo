package org.binu.client;

import org.binu.scores.PlayerScore;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.binu.util.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application entry point
 */
@Configuration
@ComponentScan
public class FizzBuzzTest {

    private static final Logger logger = LogManager.getLogger(FizzBuzzTest.class);

    @Bean
    public PlayerScore playerScoreService() {
        return new PlayerScore();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ApplicationContext context = new AnnotationConfigApplicationContext(FizzBuzzTest.class);

        final PlayerScore playerScore = context.getBean(PlayerScore.class);
        playerScore.setName("Binu");
        playerScore.setScore(20);

        session.save(playerScore);

        session.getTransaction().commit();
        session.close();

        logger.info("Bye bye!");
        HibernateUtil.getSessionFactory().close();
    }
}
