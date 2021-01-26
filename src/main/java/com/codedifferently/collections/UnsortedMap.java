package com.codedifferently.collections;

import java.util.LinkedList;
import java.util.Objects;

public class UnsortedMap<K, V> implements Map<K, V>{

    LinkedList<Entry>[] hashMap = new LinkedList[2];
    int size = 0;
    public UnsortedMap(){
    }
    @Override
    public void put(K key, V value) {
        if(size >= hashMap.length) {
            resize();
        }
        int ix = getIndex(key) % hashMap.length;
        if(hashMap[ix] == null){
            hashMap[ix] = new LinkedList<>();
        } else {
            for (Entry entry : hashMap[ix]){
                if(entry.key.equals(key)){
                    entry.value = value;
                    size++;
                    return;
                }
            }
        }
        hashMap[ix].add(new Entry(key, value));
        size++;
        return;
    }
    @Override
    public V get(K key) {
        int ix = getIndex(key) % hashMap.length;
        if(hashMap[ix] == null) return null;
        for(Entry entry : hashMap[ix]){
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
        if(hashMap[ix] == null) return;
        Entry toRemove = null;
        for(Entry entry : hashMap[ix]){
            if (entry.key.equals(key)){
                toRemove = entry;
                break;
            }
        }
        if(toRemove == null) return;
        hashMap[ix].remove(toRemove);
    }

    @Override
    public Integer size() {
        int counter = 0;
        for (LinkedList<Entry> bucket : hashMap) {
            for (int i = 0; i < bucket.size(); i++) {
                counter++;
            }
        }
        return counter;
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
        for (LinkedList<Entry> bucket : hashMap) {
            for (int i = 0; i < bucket.size(); i++) {
                if (value == bucket.get(i).value)
                    return true;
            }
        }
        return false;
    }

    class Entry {
        K key;
        V value;
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
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return Objects.equals(key, key1.key);
        }
        @Override
        public int hashCode(){
            return Objects.hash(key);
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