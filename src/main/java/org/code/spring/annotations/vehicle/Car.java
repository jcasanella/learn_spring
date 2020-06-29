package org.code.spring.annotations.vehicle;

import org.springframework.stereotype.Component;

@Component("car")
public class Car implements IVehicle {

    @Override
    public String getBuilder() {
        return "bmw";
    }

    @Override
    public int getMileage() {
        return 5678;
    }

    @Override
    public int getWheels() {
        return 4;
    }

    public String toString() {
        return show();
    }
}
