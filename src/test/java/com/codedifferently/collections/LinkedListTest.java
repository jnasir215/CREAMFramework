package com.codedifferently.collections;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void constructorTestA() {
        // Given
        LinkedList<String> list = new LinkedList<>();

        // When
        int expected = 0;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestB() {
        // Given
        LinkedList<String> list = new LinkedList<>("OneElement");

        // When
        int expected = 1;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestC() {
        // Given
        LinkedList<String> list = new LinkedList<>("Peter", "Kevin", "Angelino");

        // When
        int expected = 3;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestD() {
        // Given
        String[] names = { "Peter", "Kevin", "Angelino", "Jackson" };
        LinkedList<String> list = new LinkedList<>(names);

        // When
        int expected = 4;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        LinkedList<Integer> list = new LinkedList<>(0, 10, 20, 30, 40, 50, 60, 70);

        // When
        String expected = "[0, 10, 20, 30, 40, 50, 60, 70]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addTest() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("OneElement");

        // When
        int expected = 1;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Remove first element
    public void removeTestA() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.remove(0);

        // When
        String expected = "[second, third, fourth]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Remove middle element
    public void removeTestB() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.remove(1);

        // When
        String expected = "[first, third, fourth]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Remove last element
    public void removeTestC() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.remove(3);

        // When
        String expected = "[first, second, third]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFirstTest() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.removeFirst();

        // When
        String expected = "[second, third, fourth]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastTestA() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.removeLast();

        // When
        String expected = "[first, second, third]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastTestB() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.removeLast();

        // When
        String expected = "A custom implementation of a Linked List. This list currently holds no values.";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastTestC() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.removeLast();

        // When
        String expected = "[first]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get first element
    public void getTestA() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 0;
        int actual = list.get(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get middle element
    public void getTestB() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 20;
        int actual = list.get(2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get last element
    public void getTestC() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 40;
        int actual = list.get(4);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstTest() {
        // Given
        LinkedList<Character> list = new LinkedList<>();
        list.add('m');
        list.add('t');
        list.add('v');

        // When
        Character expected = 'm';
        Character actual = list.getFirst();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastTest() {
        // Given
        LinkedList<Character> list = new LinkedList<>();
        list.add('m');
        list.add('t');
        list.add('v');

        // When
        Character expected = 'v';
        Character actual = list.getLast();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get first element
    public void indexOfA() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 0;
        int actual = list.indexOf(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get middle element
    public void indexOfB() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 2;
        int actual = list.indexOf(20);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    // Get last element
    public void indexOfC() {
        // Given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // When
        int expected = 4;
        int actual = list.indexOf(40);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsItemA() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        // When
        boolean actual = list.contains("second");

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void containsItemB() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");

        // When
        boolean actual = list.contains("one hundred");

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void sizeTest() {
        // Given
        LinkedList<Character> list = new LinkedList<>();
        list.add('m');
        list.add('c');
        list.add('m');
        list.add('a');
        list.add('s');
        list.add('t');
        list.add('e');
        list.add('r');
        list.add('s');

        // When
        int expected = 9;
        int actual = list.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest() {
        // Given
        LinkedList<String> list = new LinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
        list.reverse();

        // When
        String expected = "[fifth, fourth, third, second, first]";
        String actual = list.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}