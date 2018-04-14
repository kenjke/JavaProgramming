package com.epam.aleksandr_generalov.java.lesson8.models;

import javafx.util.Pair;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@XmlRootElement
public class WeightCar extends Car implements FuelCalculator<Pair>, Serializable {

    private Pair[] cargoWeights;

    public WeightCar(String name, Integer fuelConsumption, Integer cost, String nameOfMark, String nameOfModel, Pair[] cargoWeights) {
        super(name, fuelConsumption, cost, nameOfMark, nameOfModel);
        this.cargoWeights = cargoWeights;
        calculateFuelConsumption(cargoWeights);
    }

    public Pair[] getCargoWeights() {
        return cargoWeights;
    }

    @XmlElement
    public void setCargoWeights(Pair[] cargoWeights) {
        this.cargoWeights = cargoWeights;
    }

    public static void setWeightCarComparator(Comparator<WeightCar> weightCarComparator) {
        WeightCarComparator = weightCarComparator;
    }

    @Override
    public void calculateFuelConsumption(Pair[] values) {
        this.totalFuelConsuption = getDefaultFuelConsuption();
        for (Pair<Integer, Integer> pair : values) {
            this.totalFuelConsuption += pair.getKey() * pair.getValue();
            this.totalFuelConsuption += this.totalFuelConsuption / 100;
        }
    }

    @Override
    public String toString() {
        return "WeightCar{" +
                "cargoWeights=" + Arrays.toString(cargoWeights) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WeightCar) {
            WeightCar toCompare = (WeightCar) obj;
            return this.getDefaultFuelConsuption().equals(toCompare.getDefaultFuelConsuption());
        }
        return false;
    }

    public static Comparator<WeightCar> WeightCarComparator
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
