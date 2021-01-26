package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
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
        map.put("B", 20);
        map.put("E", 50);
        map.put("C", 30);
        map.put("A", 10);
        map.put("F", 60);
        map.put("D", 40);
        map.put("G", 70);
        String expected = "Bucket: 0\n" +
                "Bucket: 1\n" +
                "Bucket: 2\n" +
                "Bucket: 3\n" +
                "Bucket: 4\n" +
                "Bucket: 5 - Pairs are: 10\n" +
                "Bucket: 6 - Pairs are: 20\n" +
                "Bucket: 7 - Pairs are: 30\n" +
                "Bucket: 8 - Pairs are: 40\n" +
                "Bucket: 9 - Pairs are: 50\n" +
                "Bucket: 10 - Pairs are: 60\n" +
                "Bucket: 11 - Pairs are: 70\n" +
                "Bucket: 12\n" +
                "Bucket: 13\n" +
                "Bucket: 14";
        String actual = map.toString();
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
        TreeSet<String> treeSet = map.getTree();
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
