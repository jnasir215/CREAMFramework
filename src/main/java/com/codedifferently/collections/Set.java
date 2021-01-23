package com.codedifferently.collections;

public interface Set<T> {

    void add(T value);

    T remove(T value);             // Removes value and returns it.

    boolean contains(T value);     // Returns true if Set contains the given value.

    Integer size();

    void clear();
}
