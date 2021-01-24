package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Test;

public class UnsortedSetTest {

    @Test
    public void add() {
        Set<Integer> set = new UnsortedSet<>();
        set.add(20);
        set.add(10);
        set.add(30);
        set.add(50);
        set.add(40);
        int expected = 5;
        int actual = set.size();
        set.list();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add2() {
        Set<Character> set = new UnsortedSet<>();
        set.add('C');
        set.add('B');
        set.add('E');
        set.add('A');
        set.add('D');
        int expected = 5;
        int actual = set.size();
        set.list();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        Set<Integer> set = new UnsortedSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.remove(20);
        Assert.assertFalse(set.contains(20));
    }

    @Test
    public void contains() {
        Set<Integer> set = new UnsortedSet<>();
        set.add(100);
        Assert.assertTrue(set.contains(100));
    }

    @Test
    public void size() {
        Set<Integer> set = new UnsortedSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        int expected = 5;
        int actual = set.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        Set<Integer> set = new UnsortedSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.clear();
        Assert.assertTrue(set.size() == 0);
    }
}