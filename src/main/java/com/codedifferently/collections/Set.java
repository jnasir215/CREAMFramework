package com.codedifferently.collections;

public interface Set<T> {

    boolean add(T input);

    boolean remove(T input);

    boolean contains(T input);

    int size();

    void clear();

    void list();
}
