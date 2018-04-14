package com.epam.aleksandr_generalov.java.lesson8.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Car implements Serializable {

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

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefaultFuelConsuption() {
        return defaultFuelConsuption;
    }

    @XmlElement
    public void setDefaultFuelConsuption(Integer defaultFuelConsuption) {
        this.defaultFuelConsuption = defaultFuelConsuption;
    }

    public Integer getCost() {
        return cost;
    }

    @XmlElement
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getNameOfMark() {
        return nameOfMark;
    }

    @XmlElement
    public void setNameOfMark(String nameOfMark) {
        this.nameOfMark = nameOfMark;
    }

    public String getNameOfModel() {
        return nameOfModel;
    }

    @XmlElement
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
