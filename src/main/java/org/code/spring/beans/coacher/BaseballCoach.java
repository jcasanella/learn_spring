package org.code.spring.beans.coacher;

import org.code.spring.beans.fortune.IFortuneService;

public class BaseballCoach implements ICoach {

    private IFortuneService fortuneService;

    public BaseballCoach(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return  "30 min baseball";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}
