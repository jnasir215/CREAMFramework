package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnsortedMapTest {

    @Test
    public void put() {
        UnsortedMap<String, Integer> map = new UnsortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsKey("First");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        UnsortedMap<String, Integer> map = new UnsortedMap<>();
        map.put("A", 10);

        int expected = 10;
        int actual = map.get("A");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        UnsortedMap<String, Integer> map = new UnsortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        map.remove("B");
        boolean expected = false;
        boolean actual = map.containsKey("B");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        UnsortedMap<String, Integer> map = new UnsortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        int expected = 3;
        int actual = map.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void empty() {
        Map<String, Integer> map = new UnsortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        map.empty();
        int expected = 0;
        int actual = map.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsKey() {
        Map<String, Integer> map = new UnsortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsKey("First");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsValue() {
        Map<String, Integer> map = new UnsortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsValue(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resize() {

    }

}