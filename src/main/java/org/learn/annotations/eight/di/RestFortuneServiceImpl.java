package org.learn.annotations.eight.di;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneServiceImpl implements IFortuneService {

    @Override
    public String getFortune() {
        return "RestFortuneServiceImpl happyness!!!!";
    }
}
