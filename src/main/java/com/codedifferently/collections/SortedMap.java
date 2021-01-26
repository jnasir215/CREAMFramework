package com.codedifferently.collections;

import java.util.List;
import java.util.LinkedList;
import java.util.TreeSet;

// This is a TreeMap
public class SortedMap<K, V> implements Map<K, V> {

    private List<KeyNode>[] buckets;                    // Buckets hold KeyNodes. KeyNodes hold pair.
    private static final int BUCKETCOUNT = 16;

    private TreeSet<K> tree;

    class KeyNode<T> {
        public T key;
        public V pair;
    }

    public SortedMap() {
        createEmptyBuckets();
        tree = new TreeSet<>();

    }

    private void createEmptyBuckets() {
        buckets = new LinkedList[BUCKETCOUNT - 1];      // Subtract 1 because arrays are 0 based.
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        tree = new TreeSet<>();
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < buckets.length; i++) {
            output += "Bucket: " + i;
            for (int j = 0; j < buckets[i].size(); j++) {
                output += " - Pairs are: " + buckets[i].get(j).pair;
            }
            if (i == buckets.length - 1 == false) {
                output += "\n";
            }
        }
        return output;
    }

    @Override
    public void put(K key, V pair) {
        int index = getIndexFromHash(key);

        List<KeyNode> keyNodes = buckets[index];

        // If there are no keys in this bucket, instantiate one
        if (keyNodes.size() == 0) {
            KeyNode keyNode = new KeyNode();
            keyNode.key = key;
            keyNode.pair = pair;
            buckets[index].add(keyNode);
            tree.add(key);
            return;
        }

        // Else, loop through every keynode to see if the key exists
        for (int i = 0; i < keyNodes.size(); i++) {
            KeyNode keyNode = keyNodes.get(i);
            if (keyNode.key == key) {
                keyNode.pair = pair;
            } else {
                // If not, create keynode for that key
                KeyNode newKeyNode = new KeyNode();
                newKeyNode.key = key;
                newKeyNode.pair = pair;
                buckets[index].add(newKeyNode);
                tree.add(key);
            }
        }
    }

    @Override
    public V get(K key) {
        int bucketIndex = getIndexFromHash(key);            // Key is the index of the bucket
        List<KeyNode> keyNodes = buckets[bucketIndex];      // Get bucket

        for (int i = 0; i < keyNodes.size(); i++) {         // Loop through all keys in bucket.
            KeyNode keyNode = keyNodes.get(i);
            if (key == keyNode.key) {                       // Find key's KeyNode.
                return (V) keyNode.pair;                    // Return the pairs associated with that key.
            }
        }
        return null;
    }

    public K getFirstKey() {
        return tree.first();
    }

    public K getLastKey() {
        return tree.last();
    }

    public TreeSet<K> getKeys() {
        return tree;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = getIndexFromHash(key);
        List<KeyNode> keyNodes = buckets[bucketIndex];

        for (int i = 0; i < keyNodes.size(); i++) {
            KeyNode keyNode = keyNodes.get(i);
            if (key == keyNode.key) {
                keyNodes.remove(i);
                tree.remove(key);
            }
        }
    }

    @Override
    public void empty() {
        createEmptyBuckets();
    }

    @Override
    public Integer size() {
        int counter = 0;
        for (List<KeyNode> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean containsKey(K key) {
        if (get(key) != null)
            return true;
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (List<KeyNode> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                if (value == bucket.get(i).pair)
                    return true;
            }
        }
        return false;
    }



    // (Method is only public for testing purposes)
    // Returns an index that has a value smaller than the length of the array. (To prevent out of range exceptions.)
    public int getIndexFromHash(K key) {
        int hash = key.hashCode();
        int index = Math.floorMod(hash, buckets.length);
        return index;
    }

    // Size of array and buckets are the same number.
    public int getArraySize() {
        return buckets.length;
    }

    public TreeSet<K> getTree() {
        return tree;
    }
}