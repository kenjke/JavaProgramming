package com.epam.aleksandr_generalov.java.lesson5.utils;

public class NegativeNumberException extends Exception {

    private Integer number;

    public NegativeNumberException(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public String getMessage() {
        return "You are not allowed to enter negative numbers here: " + this.getNumber();
    }
}
