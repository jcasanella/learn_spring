package org.learn.annotations.nine;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.nine.bean.ICoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeApp {

    private static Logger LOG = LogManager.getLogger();

    public static void main(String[] args) {

        LOG.info("Starting App");

        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext9.xml")) {

            ICoach coach = context.getBean("tennisCoach", ICoach.class);

            ICoach coach2 = context.getBean("tennisCoach", ICoach.class);

            boolean result = (coach == coach2);
            LOG.info("Are the same object {}", result);
            LOG.info("Memory location object1: {}", coach);
            LOG.info("Memory location object2: {}", coach2);
        }
    }
}
