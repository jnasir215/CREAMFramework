package com.codedifferently.collections;

import java.util.List;

public interface Map<K, P> {

    void put (K key, P pair);

    List<P> get(K key);         // Returns the pair associated with the given key.

    void remove(K key);            // Remove item by key and return its pair.

    void empty();               // Remove all elements.

    Integer size();             // Returns the number of keys.

    boolean containsKey(K key);

    boolean containsPair(P pair);
}
