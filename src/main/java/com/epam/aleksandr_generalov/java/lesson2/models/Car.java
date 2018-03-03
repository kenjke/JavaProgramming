package com.epam.aleksandr_generalov.java.lesson2.models;

public class Car {

    private String name;
    private Integer defaultFuelConsuption;
    public Integer totalFuelConsuption;
    private Integer cost;
    private String nameOfMark;
    private String nameOfModel;

    public Car() {
    }

    public Car(String name, Integer defaultFuelConsuption, Integer cost, String nameOfMark, String nameOfModel) {
        this.name = name;
        this.defaultFuelConsuption = defaultFuelConsuption;
        this.cost = cost;
        this.nameOfMark = nameOfMark;
        this.nameOfModel = nameOfModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefaultFuelConsuption() {
        return defaultFuelConsuption;
    }

    public void setDefaultFuelConsuption(Integer defaultFuelConsuption) {
        this.defaultFuelConsuption = defaultFuelConsuption;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getNameOfMark() {
        return nameOfMark;
    }

    public void setNameOfMark(String nameOfMark) {
        this.nameOfMark = nameOfMark;
    }

    public String getNameOfModel() {
        return nameOfModel;
    }

    public void setNameOfModel(String nameOfModel) {
        this.nameOfModel = nameOfModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", defaultFuelConsuption=" + defaultFuelConsuption +
                ", totalFuelConsuption=" + totalFuelConsuption +
                ", cost=" + cost +
                ", nameOfMark='" + nameOfMark + '\'' +
                ", nameOfModel='" + nameOfModel + '\'' +
                '}';
    }
}
