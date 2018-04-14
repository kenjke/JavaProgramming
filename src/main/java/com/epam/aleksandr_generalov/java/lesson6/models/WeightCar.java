package com.epam.aleksandr_generalov.java.lesson6.models;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class WeightCar extends Car implements FuelCalculator<Pair>, Serializable {

    private Pair[] cargoWeights;

    public WeightCar(String name, Integer fuelConsumption, Integer cost, String nameOfMark, String nameOfModel, Pair[] cargoWeights) {
        super(name, fuelConsumption, cost, nameOfMark, nameOfModel);
        this.cargoWeights = cargoWeights;
        calculateFuelConsumption(cargoWeights);
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
