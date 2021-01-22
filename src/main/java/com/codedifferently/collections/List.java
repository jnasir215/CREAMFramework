package com.codedifferently.collections;

public interface List<T> {

    void add(T input);

    void remove(T input);

    T get(int index);

    boolean isEmpty();

    boolean contains(T input);

    int size();
}
