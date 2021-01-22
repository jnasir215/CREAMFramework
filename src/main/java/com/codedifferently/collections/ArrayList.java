package com.codedifferently.collections;

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
        T[] holdArray = (T[])new Object[tempArray.length];
        boolean reachedRemovedValue = false;
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == null)
                break;
            if (tempArray[i].equals(input)) {
                reachedRemovedValue = true;
                continue;
            }
            if (reachedRemovedValue == false) {
                holdArray[i] = tempArray[i];
            } else {
                holdArray[i-1] = tempArray[i];
            }
        }
        tempArray = holdArray;
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
            if (tempArray[i] == null) {
                return false;
            }
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
