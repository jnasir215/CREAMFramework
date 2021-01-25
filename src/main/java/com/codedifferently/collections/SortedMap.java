package com.codedifferently.collections;

// This is a TreeMap
public class SortedMap<K, P> implements Map<K, P> {

    private List[] buckets;
    private static final int BUCKETCOUNT = 22;

    // Binary Nodes
    class Node<T> {
        public Node left;
        public Node right;
        public T value;
    }

    public SortedMap() {
        buckets = new LinkedList[BUCKETCOUNT - 1];      // Subtract 1 because arrays are 0 based.
    }

    @Override
    public void put(K key, P pair) {
        int index = getIndexFromHashCode(key);
    }

    @Override
    public P get(K key) {
        return null;
    }

    @Override
    public P remove(K key) {
        return null;
    }

    @Override
    public void empty() {

    }

    @Override
    public Integer size() {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(P pair) {
        return false;
    }



    // Method is only public for testing purposes
    public int getIndexFromHashCode(K key) {
        int hash = key.hashCode();
        int index = Math.floorMod(hash, buckets.length);
        return index;
    }

    // Size of array and buckets are the same number.
    public int getArraySize() {
        return buckets.length;
    }
}
