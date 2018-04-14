package com.epam.aleksandr_generalov.java.lesson5.models;

public interface FuelCalculator<T> {

    void calculateFuelConsumption(T... values);
}