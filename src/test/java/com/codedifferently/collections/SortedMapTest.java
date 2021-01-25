package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Test;

public class SortedMapTest {

    @Test
    public void testIndexesAreLessThanArraySize() {
        SortedMap<String, Integer> map = new SortedMap<>();

        String[] keys = {"a", "b", "c", "d", "d", "f", "g"};
        for (String key : keys) {
            int index = map.getIndexFromHashCode(key);
            if (index > map.getArraySize()) {
                Assert.fail();
            }
        }

        // Test passes if the above Assert.fail() is never called.
    }

    @Test
    public void put() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsKey("First");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("A", 10);

        int expected = 10;
        int actual = map.get("A");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        map.remove("B");
        boolean expected = false;
        boolean actual = map.containsKey("B");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void empty() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        map.empty();
        int expected = 0;
        int actual = map.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        int expected = 3;
        int actual = map.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsKey() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsKey("First");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsValue() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("First", 1);

        boolean expected = true;
        boolean actual = map.containsValue(1);
        Assert.assertEquals(expected, actual);
    }
}