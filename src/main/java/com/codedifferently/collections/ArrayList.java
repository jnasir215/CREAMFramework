package com.codedifferently.collections;

import java.lang.reflect.Array;

public class ArrayList<T> implements List<T>{

    private T[] tempArray;

    @Override
    public void add(T input) {
        if(tempArray == null) {
            tempArray = (T[])new Object[5];
            tempArray[0] = input;
        }
        else {
            for(int i = 0; i < tempArray.length; i++) {
                if (tempArray[i] == null) {
                    tempArray[i] = input;
                    return;
                }
            }
        T[] nextArray = (T[])new Object[tempArray.length+5];
        for(int i = 0; i < tempArray.length; i++) {
                nextArray[i] = tempArray[i];
        }
        nextArray[tempArray.length] = input;
        tempArray = nextArray;
        }
    }

    @Override
    public void remove(T input) {
        //for(int i = 0; i < tempArray.length; i++) {
        //    if(tempArray[i] == null)
        //        tempArray[i] = input;
        //}
    }

    @Override
    public T get(T input) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T input) {
        for(int i = 0; i < tempArray.length; i++) {
            if (tempArray[i].equals(input)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void size() {

    }
}
