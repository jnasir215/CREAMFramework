package com.codedifferently.collections;

import java.util.LinkedList;
import java.util.Objects;

public class UnsortedMap<K, V> implements Map<K, V>{

    LinkedList<Entry>[] hashMap = new LinkedList[2]; // in each array there will be a linked list.
    int size = 0;

    public UnsortedMap(){
    }

    @Override
    public void put(K key, V value) {
        if(size >= hashMap.length) {
            resize();
        }
        int index = getIndex(key) % hashMap.length; // this gets a valid index from this calculation in the array

        if(hashMap[index] == null){                 // if the array is null, it creates a new array.
            hashMap[index] = new LinkedList<>();
        } else {                                    // this checks if the key is already there, it replaces the existing value with the new value
            for (Entry entry : hashMap[index]){
                if(entry.key.equals(key)){
                    entry.value = value;
                    size++;
                    return;
                }
            }
        }
        hashMap[index].add(new Entry(key, value)); // if there is no duplicate it adds the new key and value to the end of the array
        size++;
        return;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key) % hashMap.length;

        if(hashMap[index] == null) return null;

        for(Entry entry : hashMap[index]){          // loops through the elements in that position.
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        if(key == null) return;

        int ix = getIndex(key) % hashMap.length;

        if(hashMap[ix] == null) return;             // if null it returns because there is nothing to remove.

        Entry toRemove = null;

        for(Entry entry : hashMap[ix]){             // loops through the entries in that index position
            if (entry.key.equals(key)){
                toRemove = entry;
                break;
            }
        }

        if(toRemove == null) return;                // if toRemove is null, there will be nothing to remove, so it returns.

        hashMap[ix].remove(toRemove);
        size--;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public void empty() {
        if(hashMap == null) {
            return;
        }
    }
    @Override
    public boolean containsKey(K key) {
        if(key == null) return false;
        int ix = getIndex(key) % hashMap.length;
        if (hashMap[ix] == null){
            return false;
        }
        for (Entry entry : hashMap[ix]) {
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean containsValue(V value) {
        if(value == null) return false;
        for (int i = 0; i < hashMap.length; i++) {
            for (Entry entry : hashMap[i]) {
                if (entry.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    class Entry {
        public K key;
        public V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    class Key<K> {
        public int key;
        public Key(int k) {
            key = k;
        }
        // this is checks to see if the keys are equal to each other, if it is, returns true, if not returns false
        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Key key1 = (Key) obj;
            return Objects.equals(key, key1.key);
        }
        @Override
        public int hashCode(){
            return Objects.hash(key); // every object has a hash, this will return a unique hash code of our object
        }
    }

    class Value<P> {
        public int value;
        public Value(int v) {
            value = v;
        }
        public int getValue() {
           return value;
       }
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Value value1 = (Value) o;
            return value == value1.value;
        }
    }

    public void resize(){
        LinkedList<Entry>[] oldHashMap = hashMap;
        hashMap = new LinkedList[size * 2];
        size = 0;
        for (int i = 0; i < oldHashMap.length; i++) {
            if(oldHashMap[i] == null) continue;
            for (Entry entry : oldHashMap[i]) {
                put(entry.key, entry.value);
            }
        }
    }
    public int getIndex(K key){
        return key.hashCode();
    }
}