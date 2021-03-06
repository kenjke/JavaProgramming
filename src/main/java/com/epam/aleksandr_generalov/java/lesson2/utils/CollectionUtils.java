package com.epam.aleksandr_generalov.java.lesson2.utils;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class CollectionUtils {

    public static <T extends Comparable<? super T>> void sort(ArrayList<?> object, Comparator<? super T> c) {
        Arrays.sort(object.getValues(), (Comparator) c);
    }

    public static <T> void print(ArrayList<T> object) {
        for (T t : object) {
            System.out.println(t.toString());
        }
    }
}