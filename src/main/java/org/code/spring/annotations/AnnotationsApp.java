package org.code.spring.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.code.spring.annotations.vehicle.Car;
import org.code.spring.annotations.vehicle.IVehicle;
import org.code.spring.annotations.vehicle.Motorbike;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsApp {

    public static void main(String[] args) {

        final Logger logger = LogManager.getLogger(AnnotationsApp.class);

        try(ClassPathXmlApplicationContext app =
                    new ClassPathXmlApplicationContext("applicationContextAnnotations.xml")) {

            IVehicle vehicle = app.getBean("car", Car.class);
            logger.info("Bean: {}", vehicle);

            IVehicle vehicle2 = app.getBean("motorbike", Motorbike.class);
            logger.info("Bean: {}", vehicle2);
        }

    }
}
