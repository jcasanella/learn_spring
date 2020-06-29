package org.code.spring.annotations.vehicle;

public interface IVehicle {

    String getBuilder();

    int getMileage();

    int getWheels();

    default String show() {
        return getBuilder() + " " + getMileage() + " " + getWheels();
    }
}
