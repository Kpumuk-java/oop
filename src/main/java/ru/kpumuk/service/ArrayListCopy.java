package ru.kpumuk.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListCopy<T> {
    private T[] array;
    private int defaultSize = 10;
    private int size;

    public ArrayListCopy() {
        this.array = (T[]) new Object[defaultSize];
    }

    public ArrayListCopy(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    private void highCapacity() {
        T[] arrayBuffer = Arrays.copyOf(array, (int) (array.length * 1.5));
        array = arrayBuffer;
    }
    private void lessCapacity() {
        T[] arrayBuffer = (T[]) new Object[(int) (size * 1.5)];
        arrayBuffer = Arrays.copyOfRange(array, 0, size);
        array = arrayBuffer;
    }

    private void insertElementInArray (int position, Object o) {
        for (int i = size; i >= position + 1; i--) {
            array[i] = array[i - 1];
        }
        array[position] = (T) o;
        size++;
    }


    public boolean insert(int position, Object o) {
        if (size == array.length){
            highCapacity();
        }
        insertElementInArray(position, o);
        return true;
    }

    public void add (Object o) {
        if (size == array.length) {
            highCapacity();
        }
        array[size++] = (T) o;
    }

    public void remove (int position) {
        for (int i = position; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if ((size / array.length) > 2) {
            lessCapacity();
        }
    }

    @Override
    public String toString() {
        return "ArrayListCopy{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}



