package com.company.classes;

import com.company.enumFolder.CarState;
import com.company.enumFolder.CarType;

public class Car {
    private int id;
    private String model, driver_name;
    private CarState carState;
    private CarType carType;

    public Car() {
    }

    public Car(int id, String model, String driver_name, CarState carState, CarType carType) {
        this.id = id;
        this.model = model;
        this.driver_name = driver_name;
        this.carState = carState;
        this.carType = carType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "N        : " + id + '\n' +
                "Bus      : " + model + '\n' +
                "Driver   : " + driver_name + '\n' +
                "Bus state : " + carState;
    }

    public static Car addCar(int id, String model, String driver_name, CarState carState, CarType carType) {
        Car car = new Car();
        car.id = id;
        car.model = model;
        car.driver_name = driver_name;
        car.carState = carState;
        car.carType = carType;
        return car;
    }

}
