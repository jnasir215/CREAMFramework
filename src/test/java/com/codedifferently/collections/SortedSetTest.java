package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortedSetTest {

    Set<Character> testSet;

    @Before
    public void setup() {
        testSet = new SortedSet<>();
    }

    @Test
    public void add() {
        testSet.add('C');
        testSet.add('B');
        testSet.add('A');
        testSet.add('B');

        boolean expected = true;
        boolean actual = testSet.contains('C');

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        testSet.add('A');
        testSet.add('B');
        testSet.add('C');
        testSet.add('B');
        testSet.remove('C');

        boolean expected = false;
        boolean actual = testSet.contains('C');

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains_true() {
        testSet.add('A');
        testSet.add('B');
        testSet.add('C');
        testSet.add('B');
        testSet.add('D');
        testSet.remove('C');

        testSet.list();
        boolean expected = true;
        boolean actual = testSet.contains('B');

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains_false() {
        testSet.add('A');
        testSet.add('B');
        testSet.add('C');
        testSet.add('B');
        testSet.add('D');
        testSet.remove('C');

        testSet.list();
        boolean expected = false;
        boolean actual = testSet.contains('C');

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        testSet.add('A');
        testSet.add('B');
        testSet.add('C');
        testSet.add('B');
        testSet.add('D');
        testSet.remove('C');

        testSet.list();
        int expected = 3;
        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        testSet.add('A');
        testSet.add('B');
        testSet.add('C');
        testSet.add('B');
        testSet.add('D');

        testSet.list();
        testSet.clear();
        testSet.list();

        int expected = 0;
        int actual = testSet.size();
        Assert.assertEquals(expected, actual);
    }
}