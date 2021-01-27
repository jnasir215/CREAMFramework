package com.codedifferently.collections;

import java.util.TreeSet;

public class SortedMap<K, V> implements Map<K, V> {

    private List<KeyNode>[] buckets;                    // Buckets hold KeyNodes. KeyNodes hold key and pair.
    private static final int BUCKETCOUNT = 16;

    private TreeSet<K> sortedKeysTree;

    class KeyNode<T> {
        public T key;
        public V pair;
    }

    public SortedMap() {
        createEmptyBuckets();
    }

    // Instantiates an empty linked list for every bucket. Clears existing values if any exist.
    private void createEmptyBuckets() {
        buckets = new LinkedList[BUCKETCOUNT - 1];      // Subtract 1 because arrays are 0 based.
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        sortedKeysTree = new TreeSet<>();
    }

    // Prints all buckets and shows each key and pair in that bucket
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < buckets.length; i++) {
            output += "Bucket " + i;
            output += (i < 10) ? "  -> " : " -> ";
            for (int j = 0; j < buckets[i].size(); j++) {
                output += (j > 0) ? ", " : "";
                output += String.format("(key %s : value %s)", buckets[i].get(j).key, buckets[i].get(j).pair);
            }
            if (i == buckets.length - 1 == false) {
                output += "\n";
            }
        }
        return output;
    }

    // Add a key value pair. If the key already exists, replace its pair with the new pair.
    @Override
    public void put(K key, V pair) {
        int index = getIndexFromHash(key);

        List<KeyNode> keyNodes = buckets[index];

        // If bucket is empty, add key
        if (keyNodes.size() == 0) {
            addNewKey(key, pair, index);
            return;
        }

        // If bucket is not empty, loop through all keys in bucket.
        for (int i = 0; i < keyNodes.size(); i++) {
            KeyNode keyNode = keyNodes.get(i);
            if (keyNode.key == key) {                       // If key already exists, replace its pair with the new pair.
                keyNode.pair = pair;
            } else {
                addNewKey(key, pair, i);                    // If key does not exist, add key to bucket
            }
        }
    }

    // Adds key to the given bucket
    private void addNewKey(K key, V pair, int bucketIndex) {
        KeyNode keyNode = new KeyNode();
        keyNode.key = key;
        keyNode.pair = pair;
        buckets[bucketIndex].add(keyNode);
        sortedKeysTree.add(key);
    }

    // Returns the pair associated with the key
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
        return sortedKeysTree.first();
    }

    public K getLastKey() {
        return sortedKeysTree.last();
    }

    public TreeSet<K> getKeys() {
        return sortedKeysTree;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = getIndexFromHash(key);
        List<KeyNode> keyNodes = buckets[bucketIndex];

        for (int i = 0; i < keyNodes.size(); i++) {
            KeyNode keyNode = keyNodes.get(i);
            if (key == keyNode.key) {
                keyNodes.remove(keyNode);
                sortedKeysTree.remove(key);
            }
        }
    }

    @Override
    public void empty() {
        createEmptyBuckets();
    }

    @Override
    public Integer size() {
        return sortedKeysTree.size();
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
        int index = Math.abs(hash % buckets.length);
        return index;
    }

    // Size of array and buckets are the same number.
    public int getArraySize() {
        return buckets.length;
    }

    public TreeSet<K> getSortedKeysTree() {
        return sortedKeysTree;
    }
}