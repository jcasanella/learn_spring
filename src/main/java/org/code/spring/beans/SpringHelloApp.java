package org.code.spring.beans;

import org.code.spring.beans.board.Wakeboard;
import org.code.spring.beans.coacher.CricketCoach;
import org.code.spring.beans.water.IWaterSport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

    public static void main(String[] args) {

        // Load the configuration file
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("/applicationContext.xml")) {

            CricketCoach myCoach = context.getBean("myCoach2", CricketCoach.class);

            // call methods
            System.out.println("Spring App starting");
            System.out.println(myCoach.getDailyWorkout());
            System.out.println(myCoach.getDailyFortune());
            System.out.println(myCoach.getEmailAddress());
            System.out.println(myCoach.getTeamName());

            IWaterSport ks = context.getBean("waterFun", Wakeboard.class);
            System.out.println(String.format("%s %s %b", ks.getType(), ks.getLocation(), ks.isBanana()));
        }
    }
}
