package com.epam.aleksandr_generalov.java.lesson8.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@XmlRootElement
public class LightCar extends Car implements FuelCalculator<Integer>, Serializable {

    private Integer[] passengersWeight;

    public LightCar(String name, Integer defaultFuelConsumption, Integer cost, String nameOfMark, String nameOfModel, Integer[] passengersWeight) {
        super(name, defaultFuelConsumption, cost, nameOfMark, nameOfModel);
        this.passengersWeight = passengersWeight;
        calculateFuelConsumption(passengersWeight);
    }

    public Integer[] getPassengersWeight() {
        return passengersWeight;
    }

    @XmlElement
    public void setPassengersWeight(Integer[] passengersWeight) {
        this.passengersWeight = passengersWeight;
    }

    @Override
    public void calculateFuelConsumption(Integer... values) {
        this.totalFuelConsuption = getDefaultFuelConsuption();
        for (Integer weight : values) {
            this.totalFuelConsuption += weight;
        }
    }

    @Override
    public String toString() {
        return "LightCar{" +
                "passengersWeight=" + Arrays.toString(passengersWeight) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LightCar) {
            LightCar toCompare = (LightCar) obj;
            return this.getDefaultFuelConsuption().equals(toCompare.getDefaultFuelConsuption());
        }
        return false;
    }

    public static Comparator<LightCar> LightCarComparator
            = (o1, o2) -> {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.totalFuelConsuption > o2.totalFuelConsuption) {
            return 1;
        } else if (o1.totalFuelConsuption < o2.totalFuelConsuption) {
            return -1;
        } else if (o1.getCost() > o2.getCost()) {
            return 1;
        } else if (o1.getCost() < o2.getCost()) {
            return -1;
        } else if (o1.getDefaultFuelConsuption() > o2.getDefaultFuelConsuption()) {
            return 1;
        } else if (o1.getDefaultFuelConsuption() < o2.getDefaultFuelConsuption()) {
            return -1;
        }
        return 0;
    };
}
