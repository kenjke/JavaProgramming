package com.epam.aleksandr_generalov.java.lesson6.utils;

public interface List<E> {
    
    void add(E value);

    E get(int index);

    void set(int index, E value);

    void add(int index, E value);

    int indexOf(E value);

    int size();

    E remove(int index);

    boolean remove(E value);

    boolean contains(E o);
}
