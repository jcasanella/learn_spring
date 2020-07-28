package org.learn.annotations.nine.di;

import org.learn.annotations.eight.di.IFortuneService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneServiceImpl implements IFortuneService {

    private List<String> values = Arrays.asList( new String[] {
            "today rail",
            "wakeboard",
            "testing"
    });

    private Random random = new Random();

    @Override
    public String getFortune() {

        int idx = random.nextInt(values.size());
        return values.get(idx);
    }
}
