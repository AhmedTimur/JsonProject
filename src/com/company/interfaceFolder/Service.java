package com.company.interfaceFolder;

import com.company.classes.Car;
import com.company.classes.Drivers;

import java.util.List;

public interface Service {
    void changeDriver(Drivers drivers, Car car);
    void startDriving(Drivers drivers, Car car);
    void startRepair(Drivers drivers, Car car);
}
