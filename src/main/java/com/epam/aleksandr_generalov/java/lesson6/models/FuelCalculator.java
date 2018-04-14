package com.epam.aleksandr_generalov.java.lesson6.models;

public interface FuelCalculator<T> {

    void calculateFuelConsumption(T... values);
}