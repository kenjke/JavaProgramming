package com.epam.aleksandr_generalov.java.lesson8.models;

public interface FuelCalculator<T> {

    void calculateFuelConsumption(T... values);
}