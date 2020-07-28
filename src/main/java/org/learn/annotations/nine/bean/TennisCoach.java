package org.learn.annotations.nine.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class TennisCoach implements ICoach, DisposableBean {

    private Logger LOG = LogManager.getLogger();

    @Autowired
    @Qualifier("randomFortuneServiceImpl")
    private IFortuneService fortuneService;

    @PostConstruct
    void startUp() {
        LOG.info("Calling startup Object");
    }

    @Override
    public String getDailyWorkout() {
        return "testing with bean scope workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @PreDestroy
//    void shutdown() {
//        LOG.info("Destroy object!!!");
//    }

    @Override
    public void destroy() throws Exception {
        LOG.info("Destroy object!!!");
    }
}
