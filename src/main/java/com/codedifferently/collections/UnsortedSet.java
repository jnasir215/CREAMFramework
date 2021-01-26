package com.codedifferently.collections;

import java.util.Map;
import java.util.HashMap;

<<<<<<< HEAD
// This is a HashSet
=======
>>>>>>> origin/origin/unsortedmap
public class UnsortedSet<T> implements Set<T> {

    // UnsortedSet is actually just a hashmap without pairs. The pair here can be any type because it is never used.
    private Map<T, Integer> hashMap;

    public UnsortedSet() {
        hashMap = new HashMap<>();
    }

    @Override
<<<<<<< HEAD
    public boolean add(T value) {
        return hashMap.put(value, 0) == null;
    }

    @Override
    public void remove(T value) {
        hashMap.remove(value);
=======
    public void add(T value) {
        hashMap.put(value, 0);
    }

    @Override
    public T remove(T value) {
        hashMap.remove(value);
        return value;
>>>>>>> origin/origin/unsortedmap
    }

    @Override
    public boolean contains(T value) {
        if (hashMap.get(value) != null)
            return true;
        return false;
    }

    @Override
<<<<<<< HEAD
    public int size() {
=======
    public Integer size() {
>>>>>>> origin/origin/unsortedmap
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
<<<<<<< HEAD

    @Override
    public void list() {
        System.out.println(hashMap.keySet());
    }
=======
>>>>>>> origin/origin/unsortedmap
}
