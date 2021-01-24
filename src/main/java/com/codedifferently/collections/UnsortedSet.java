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
    public boolean add(T value) {
        return hashMap.put(value, 0) == null;
    }

    @Override
    public void remove(T value) {
        hashMap.remove(value);
    }

    @Override
    public boolean contains(T value) {
        if (hashMap.get(value) != null)
            return true;
        return false;
    }

    @Override
    public int size() {
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

    @Override
    public void list() {
        System.out.println(hashMap.keySet());
    }
}
