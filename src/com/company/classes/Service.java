package com.company.classes;

import com.company.exceptionsFolder.ChangeDriverException;
import com.company.exceptionsFolder.TruckStateException;

import java.util.Random;

import static com.company.enumFolder.CarState.*;

public class Service implements com.company.interfaceFolder.Service {

    @Override
    public void changeDriver(Drivers drivers, Car car) {
        if(car.getCarState().equals(BASE)){
            car.setDriver_name(drivers.getName());
            drivers.setBus(car.getModel());
            System.out.println("Done... The truck " + car.getModel() + "'s driver is: " + drivers.getName());
        }
        if (car.getCarState().equals(ROUTE)) {
            throw new ChangeDriverException("The driver on the road. You cannot change this driver");
        }
        if(car.getCarState().equals(REPAIR)) {
            throw new ChangeDriverException("The truck in repair. You cannot change the driver");
        }
    }

    @Override
    public void startDriving(Drivers drivers, Car car) {
        if(car.getCarState().equals(BASE) && car.getDriver_name() != null) {
            car.setCarState(ROUTE);
            car.setDriver_name(drivers.getName());
            System.out.println("The truck is on the road");
        }
        else if(car.getCarState().equals(ROUTE)) {
            throw new TruckStateException("The truck is on the road!");
        }
        else if(car.getCarState().equals(REPAIR)) {
            Random random = new Random();
            int a = random.nextInt(1,3);
            if(a == 1)
                car.setCarState(ROUTE);
            else
                car.setCarState(BASE);
            System.out.println("The trucks state is: " + car.getCarState());
        }
    }

    @Override
    public void startRepair(Drivers drivers, Car car) {
        if(car.getCarState().equals(BASE) || car.getCarState().equals(ROUTE)) {
            car.setCarState(REPAIR);
            System.out.println("The truck is in repair");
        }
        else if(car.getCarState().equals(REPAIR))
            throw new TruckStateException("This truck is already in repair!");
    }
}
