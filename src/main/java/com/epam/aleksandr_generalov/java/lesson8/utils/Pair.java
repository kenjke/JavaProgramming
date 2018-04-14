package com.epam.aleksandr_generalov.java.lesson8.utils;

import java.util.Iterator;

public class Pair implements Iterable<Pair> {

    private Integer coefficient;
    private Integer weight;

    public Pair() {
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public Iterator<Pair> iterator() {
        return this.iterator();
    }
}
