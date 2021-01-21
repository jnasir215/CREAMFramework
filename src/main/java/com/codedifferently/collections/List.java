package com.codedifferently.collections;

public interface List<T> {

    void add(T input);

    void remove(T input);

    T get(T input);

    boolean isEmpty();

    boolean contains(T input);

    void size();
}
