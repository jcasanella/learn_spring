package org.code.spring;

import org.code.spring.beans.coacher.ICoach;
import org.code.spring.beans.coacher.TrackCoach;

public class MyApp {

    public static void main(String[] args) {

        ICoach coach = new TrackCoach();
        System.out.println(coach.getDailyWorkout());
    }
}
