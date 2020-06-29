package org.code.spring.beans.fortune;

public class HappyFortuneService implements IFortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!!!";
    }
}
