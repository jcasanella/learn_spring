package org.code.spring.annotations.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Motorbike implements IVehicle {
    @Override
    public String getBuilder() {
        return "yamaha";
    }

    @Override
    public int getMileage() {
        return 45000;
    }

    @Override
    public int getWheels() {
        return 2;
    }

    public String toString() {
        return show();
    }
}
