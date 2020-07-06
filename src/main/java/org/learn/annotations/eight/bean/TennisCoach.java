package org.learn.annotations.eight.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach {

    private IFortuneService fortuneService;
    private static final Logger LOGGER = LogManager.getLogger(TennisCoach.class);

    @Autowired
    public TennisCoach(IFortuneService fortuneService) {
        LOGGER.info("Calling the constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        LOGGER.info("getDailyWorkout");
        return "A lot of balls";
    }

    @Override
    public String getDailyFortune() {
        LOGGER.info("getDailyFortune");
        return this.fortuneService.getFortune();
    }
}
