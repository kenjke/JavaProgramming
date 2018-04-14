package com.epam.aleksandr_generalov.java.lesson8.utils;

import com.epam.aleksandr_generalov.java.lesson8.models.Car;

import java.io.*;

public class Serializator {

    public static void writeFile(String fileName, Object object) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Car readFile(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Car car = (Car) in.readObject();
            in.close();
            fileIn.close();
            return car;
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return null;
    }
}
