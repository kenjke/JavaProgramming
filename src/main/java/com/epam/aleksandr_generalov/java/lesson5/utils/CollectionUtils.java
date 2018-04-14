package com.epam.aleksandr_generalov.java.lesson5.utils;

import com.epam.aleksandr_generalov.java.lesson5.models.LightCar;
import com.epam.aleksandr_generalov.java.lesson5.models.WeightCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class CollectionUtils {

    public static <T extends Comparable<? super T>> void sort(ArrayList<WeightCar> object, Comparator<LightCar> c) {
        Arrays.sort(object.getValues(), (Comparator) c);
    }

    public static <T> void print(ArrayList<T> object) {
        for (T t : object) {
            System.out.println(t.toString());
        }
    }
}
