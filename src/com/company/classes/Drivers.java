package com.company.classes;

import com.company.enumFolder.CarState;
import com.company.enumFolder.CarType;

public class Drivers {
    private int id;
    private String name, bus;

    public Drivers(int id, String name, String bus) {
        this.id = id;
        this.name = name;
        this.bus = bus;
    }

    public Drivers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bus='" + bus + '\'' +
                '}';
    }

    public static Drivers addDrivers(int id, String name, String bus) {
        Drivers drivers = new Drivers();
        drivers.id = id;
        drivers.name = name;
        drivers.bus = bus;
        return drivers;
    }

}
