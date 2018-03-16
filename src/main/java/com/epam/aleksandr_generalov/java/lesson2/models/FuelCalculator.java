package com.epam.aleksandr_generalov.java.lesson2.models;

public interface FuelCalculator<T> {

    void calculateFuelConsumption(T... values);
}