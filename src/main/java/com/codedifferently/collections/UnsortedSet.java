package com.codedifferently.collections;

import java.util.Map;
import java.util.HashMap;

public class UnsortedSet<T> implements Set<T> {

    // UnsortedSet is actually just a hashmap without pairs. The pair here can be any type because it is never used.
    private Map<T, Integer> hashMap;

    public UnsortedSet() {
        hashMap = new HashMap<>();
    }

    @Override
    public void add(T value) {
        hashMap.put(value, 0);
    }

    @Override
    public T remove(T value) {
        hashMap.remove(value);
        return value;
    }

    @Override
    public boolean contains(T value) {
        if (hashMap.get(value) != null)
            return true;
        return false;
    }

    @Override
    public Integer size() {
        int numOfKeys = 0;
        for (T keySet : hashMap.keySet()) {
            numOfKeys++;
        }
        return numOfKeys;
    }

    @Override
    public void clear() {
        hashMap = new HashMap<>();
    }
}
