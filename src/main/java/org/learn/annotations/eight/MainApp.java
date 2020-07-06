package org.learn.annotations.eight;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.bean.ICoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        final Logger LOGGER = LogManager.getLogger(MainApp.class);

        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext8.xml")) {

            ICoach coach = context.getBean("tennisCoach", ICoach.class);
            LOGGER.info("Call method getDailyFortune: {}", coach.getDailyFortune());
            LOGGER.info("Call method getDailyWorkout: {}", coach.getDailyWorkout());
        }
    }
}
