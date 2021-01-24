package com.codedifferently.collections;

import java.util.HashMap;
import java.util.SortedMap;

public class SortedSet<T> implements Set<T> {

    private transient HashMap<T, Object> tempSet;
    private static final Object PRESENT =  new Object();

    public SortedSet() {
        tempSet = new HashMap<>();
    }

    @Override
    public boolean add(T input) {
        return tempSet.put(input, PRESENT) == null;
    }

    @Override
    public void remove(T input) {
        tempSet.remove(input);
    }

    @Override
    public boolean contains(T input) {
        return tempSet.containsKey(input);
    }

    @Override
    public int size() {
        int counter = 0;
        for(T key : tempSet.keySet()) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        tempSet = new HashMap<>();
    }

    public void list() {
        System.out.println(tempSet.keySet());
    }
}
