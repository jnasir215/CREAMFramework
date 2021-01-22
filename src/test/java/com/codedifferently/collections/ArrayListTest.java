package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    List arrayList;

    @Before
    public void setup() {
        arrayList = new ArrayList();
    }

    @Test
    public void add1() {
        String name = "DreamTeam";
        arrayList.add(name);

        boolean expected = true;
        boolean actual = arrayList.contains(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add2() {
        String name1 = "DreamTeam";
        String name2 = "TeamDream";
        arrayList.add(name1);
        arrayList.add(name2);

        boolean expected = true;
        boolean actual = arrayList.contains(name2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add3() {
        String name1 = "DreamTeam";
        String name2 = "TeamDream";
        String name3 = "DreamTeam2";
        String name4 = "TeamDream2";
        String name5 = "DreamTeam3";
        String name6 = "TeamDream3";
        arrayList.add(name1);
        arrayList.add(name2);
        arrayList.add(name3);
        arrayList.add(name4);
        arrayList.add(name5);
        arrayList.add(name6);

        boolean expected = true;
        boolean actual = arrayList.contains(name6);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        String name1 = "DreamTeam";
        String name2 = "TeamDream";
        String name3 = "DreamTeam2";
        String name4 = "TeamDream2";
        String name5 = "DreamTeam3";
        String name6 = "TeamDream3";
        arrayList.add(name1);
        arrayList.add(name2);
        arrayList.add(name3);
        arrayList.add(name4);
        arrayList.add(name5);
        arrayList.add(name6);
        arrayList.remove(name4);

        boolean expected = false;
        boolean actual = arrayList.contains(name4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void size() {
    }

}
