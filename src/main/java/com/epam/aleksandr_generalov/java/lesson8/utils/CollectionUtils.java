package com.epam.aleksandr_generalov.java.lesson8.utils;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class CollectionUtils {

    public static <T> void print(ArrayList<T> object) {
        for (T t : object) {
            System.out.println(t.toString());
        }
    }
}
