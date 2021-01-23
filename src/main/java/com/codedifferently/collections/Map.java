package com.codedifferently.collections;

public interface Map<K, P> {

    void put (K key, P pair);

    P get(K key);               // Returns the pair associated with the given key.

    P remove(K key);            // Remove item by key and return its pair.

    void empty();               // Remove all elements.

    Integer size();             // Returns the number of keys.

    boolean containsKey(K key);

    boolean containsValue(P pair);
}
