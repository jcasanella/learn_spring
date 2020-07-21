package org.learn.annotations.eight.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements ICoach {

    private static final Logger LOGGER = LogManager.getLogger(BasketballCoach.class);

    @Autowired
    @Qualifier("happyFortuneServiceImpl")
    private IFortuneService fortuneService;

    public BasketballCoach() {

    }

    @Override
    public String getDailyWorkout() {
        LOGGER.info("Calling getDailyWorkout");
        return "Michael Jordan trainning";
    }

    @Override
    public String getDailyFortune() {
        LOGGER.info("Calling getDailyFortune");
        return this.fortuneService.getFortune();
    }

//    @Autowired
//    public void setFortuneService(IFortuneService fortuneService) {
//        LOGGER.info("Calling setFortuneService");
//        this.fortuneService = fortuneService;
//    }
}
