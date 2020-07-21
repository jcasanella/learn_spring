package org.learn.annotations.eight.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements ICoach {

    private static final Logger LOGGER = LogManager.getLogger(FootballCoach.class);

    @Autowired
    @Qualifier("restFortuneServiceImpl")
    private IFortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        LOGGER.info("Calling getDailyWorkout");
        return "Another goal!!!";
    }

    @Override
    public String getDailyFortune() {
        LOGGER.info("Calling getDailyFortune!!!");
        return this.fortuneService.getFortune();
    }
}
