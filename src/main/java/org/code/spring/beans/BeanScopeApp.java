package org.code.spring.beans;

import org.code.spring.beans.coacher.CricketCoach;
import org.code.spring.beans.coacher.ICoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {

    public static void main(String[] args) {

        try(ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("/applicationContextScope.xml")) {

            ICoach cricket = context.getBean("myCoach", CricketCoach.class);

            ICoach cricket2 = context.getBean("myCoach", CricketCoach.class);

            boolean result = (cricket == cricket2);
            System.out.println("Are the same object: " + result);
            System.out.println("Memory first object: " + cricket);
            System.out.println("Memory second object: " + cricket2);

            System.out.println(cricket.getDailyWorkout());
        }

    }
}
