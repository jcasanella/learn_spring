package org.learn.annotations.eight.di;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneServiceImpl implements IFortuneService {

    @Override
    public String getFortune() {
        return "This is the HappyFortuneServiceImpl";
    }
}
