package com.codedifferently.collections;

public interface Map<K, V> {

    void put (K key, V value);

    V get(K key);               // Returns the pair associated with the given key.

    void remove(K key);            // Remove item by key and return its pair.

    void empty();               // Remove all elements.

    Integer size();             // Returns the number of keys.

    boolean containsKey(K key);

    boolean containsValue(V value);
}
