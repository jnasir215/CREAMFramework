package com.codedifferently.collections;

public interface Set<T> {

    boolean add(T input);

    void remove(T input);

    boolean contains(T input);

    int size();

    void clear();

    void list();
}
