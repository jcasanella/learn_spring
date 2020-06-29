package org.code.spring.beans.coacher;

import org.code.spring.beans.fortune.IFortuneService;
import org.springframework.beans.factory.DisposableBean;

public class CricketCoach implements ICoach, DisposableBean {

    private IFortuneService fortuneService;
    private String emailAddress;
    private String teamName;

    public CricketCoach(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket training";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public void setFortuneService(IFortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeamName() {
        return teamName;
    }

    public void startUp() {
        System.out.println("Starting the object!!!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Stopping objects");
    }
}
