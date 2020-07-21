package org.learn.annotations.eight.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements ICoach {

    private static final Logger LOGGER = LogManager.getLogger(BasketballCoach.class);
    private IFortuneService fortuneService;

    @Value("${foo.teamName}")
    private String teamName;

    @Autowired
    public BaseballCoach(@Qualifier("fortuneServiceImpl") IFortuneService fortuneService) {

        System.out.println("In the constructor baseballCoach");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        LOGGER.info("Calling getDailyWorkout");
        return "Strike!!!!";
    }

    @Override
    public String getDailyFortune() {
        LOGGER.info("Calling getDailyFortune");
        return this.fortuneService.getFortune() + " ************ " + teamName;
    }

//    @Autowired
//    public void doSomeStuff(IFortuneService fortuneService) {
//        LOGGER.info("Calling doSomeStuff");
//        this.fortuneService = fortuneService;
//    }
}
