package org.learn.annotations.eight.di;

import org.springframework.stereotype.Component;

@Component
public class FortuneServiceImpl implements IFortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!!!";
    }
}
