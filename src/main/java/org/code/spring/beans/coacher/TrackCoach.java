package org.code.spring.beans.coacher;

import org.code.spring.beans.fortune.IFortuneService;

public class TrackCoach implements ICoach {

    private IFortuneService fortuneService;

    public TrackCoach() {}

    public TrackCoach(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "30 min track";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it " + fortuneService.getFortune();
    }
}
