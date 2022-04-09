package com.company;

import com.company.classes.Car;
import com.company.classes.Drivers;
import com.google.gson.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static com.company.enumFolder.CarState.*;
import static com.company.enumFolder.CarType.*;

public class FistAndSecondStages {

    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./car.gson");
    public static final Path WRITE_PATH_DRIVER = Paths.get("./driver.gson");

    public static void main(String[] args) {

        List<Car> trucks = new ArrayList<>();
        trucks.add(Car.addCar(1, "Renault Magnum", "", BASE, TRUCK));
        trucks.add(Car.addCar(2, "Volvo FH12", "", BASE, TRUCK));
        trucks.add(Car.addCar(3, "DAF XF", "", BASE, TRUCK));

        List<Drivers> drivers = new ArrayList<>();
        drivers.add(Drivers.addDrivers(1,"Sasha",""));
        drivers.add(Drivers.addDrivers(2,"Petya",""));
        drivers.add(Drivers.addDrivers(3,"Vasya",""));


        String jsonTruck = GSON.toJson(trucks);
        setWritePath(jsonTruck);
//        System.out.println(readFile());
        printTable(trucks);

        System.out.println();
        System.out.println("********************************************************************************");

        String jsonDriver = GSON.toJson(drivers);
        setWritePathDriver(jsonDriver);
        printDriverTable(drivers);

    }

    public static void printDriverTable(List<Drivers> drivers) {
        System.out.println();
        System.out.println("-----------  DRIVERS  -----------");
        System.out.println("   #   |  Driver             |  Bus               ");
        System.out.println("-------+---------------------+--------------------");
        int counter = 1, tabsDriver = 20, tabsBus = 18;
        for(Drivers i: drivers) {
            System.out.print("   " + counter + "   | ");
            System.out.print(i.getName());
            for(int j = 0; j < tabsDriver - i.getName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  " + i.getBus());
            for(int j = 0; j < tabsBus; j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }

    public static void printTable(List<Car> trucks) {
        System.out.println();
        System.out.println("-----------  TRUCKS  -----------");
        System.out.println("   #   |  Bus                |  Driver            |  State         ");
        System.out.println("-------+---------------------+--------------------+----------------");
        int counter = 1, tabsBus = 20, tabsDriver = 18, tabsState = 14;
        for(Car i: trucks) {
            System.out.print("   " + counter + "   | ");
            System.out.print(i.getModel());
            for(int j = 0; j < tabsBus - i.getModel().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  " + i.getDriver_name());
            for(int j = 0; j < tabsDriver; j++) {
                System.out.print(" ");
            }
            System.out.print("|  ");
            System.out.print(i.getCarState());
            for(int j = 0; j < tabsState - i.getCarState().toString().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }

    private static void setWritePath(String object){
        Path setWritePath = Paths.get(String.valueOf(WRITE_PATH));
        try{
            Files.writeString(setWritePath, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void setWritePathDriver(String object){
        Path setWritePath = Paths.get(String.valueOf(WRITE_PATH_DRIVER));
        try{
            Files.writeString(setWritePath, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String readFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int temp;
            while ((temp = fileReader.read()) != -1) {
                json += (char) temp;
            }
            return json;
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return json;
    }


}
