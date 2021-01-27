package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

public class SortedMapTest {

    @Test
    public void testIndexesAreLessThanArraySize() {
        SortedMap<String, Integer> map = new SortedMap<>();

        String[] keys = {"a", "b", "c", "d", "d", "f", "g"};
        for (String key : keys) {
            int index = map.getIndexFromHash(key);
            if (index > map.getArraySize()) {
                Assert.fail();
            }
        }

        // Test will pass if the above Assert.fail() is never called.
    }

    @Test
    public void getFirstKey() {
        SortedMap<String, Integer> map = new SortedMap<>();
        map.put("C", 3);
        map.put("B", 2);
        map.put("E", 5);
        map.put("A", 1);
        map.put("D", 4);

        String expected = "A";
        String actual = map.getFirstKey();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastKey() {
        SortedMap<String, Integer> map = new SortedMap<>();
        map.put("C", 3);
        map.put("B", 2);
        map.put("E", 5);
        map.put("A", 1);
        map.put("D", 4);

        String expected = "E";
        String actual = map.getLastKey();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKeys() {
        SortedMap<String, Integer> map = new SortedMap<>();
        map.put("C", 3);
        map.put("B", 2);
        map.put("E", 5);
        map.put("A", 1);
        map.put("D", 4);

        String[] expected = { "A", "B", "C", "D", "E" };   // Actual must be in this order
        TreeSet<String> actual = map.getKeys();
        int index = 0;
        for (String key : actual) {
            if (expected[index] != key) {
                Assert.fail();
            }
            index++;
        }

        // Test will pass if the above Assert.fail() is never called.
    }

    @Test
    public void toStringTest() {
        Map<String, Integer> map = new SortedMap<>();
        map.put("b", 20);
        map.put("e", 11);
        map.put("c", 4);
        map.put("a", 32);
        map.put("f", 60);
        map.put("d", 40);
        map.put("g", 70);
        map.put("hi", 100);
        map.put("ok", 9);
        map.put("wow", 80);
        map.put("bee", 4);
        map.put("happen", 30);
        map.put("ardvark", 10);
        map.put("ardvaek", 20);
        map.put("jmcmasters411", 66);
        map.put("hb", 80);
        map.put("jj", 80);
        map.put("k", 80);
        String expected = "Bucket 0  -> (key ok : value 9), (key bee : value 4), (key happen : value 30), (key ardvark : value 10), (key ardvaek : value 20), (key jmcmasters411 : value 66), (key hb : value 80), (key k : value 80)\n" +
                "Bucket 1  -> \n" +
                "Bucket 2  -> (key jj : value 80)\n" +
                "Bucket 3  -> \n" +
                "Bucket 4  -> (key wow : value 80)\n" +
                "Bucket 5  -> \n" +
                "Bucket 6  -> \n" +
                "Bucket 7  -> (key a : value 32)\n" +
                "Bucket 8  -> (key b : value 20)\n" +
                "Bucket 9  -> (key c : value 4)\n" +
                "Bucket 10 -> (key d : value 40)\n" +
                "Bucket 11 -> (key e : value 11)\n" +
                "Bucket 12 -> (key f : value 60)\n" +
                "Bucket 13 -> (key g : value 70)\n" +
                "Bucket 14 -> (key hi : value 100)";
        String actual = map.toString();
        System.out.println(map.toString());
        Assert.assertEquals(expected, actual);
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
    public void emptyAndTestSize() {
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
    public void emptyAndTestTreeIsEmpty() {
        SortedMap<String, Integer> map = new SortedMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);

        map.empty();
        int expected = 0;
        TreeSet<String> treeSet = map.getSortedKeysTree();
        int actual = treeSet.size();
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
