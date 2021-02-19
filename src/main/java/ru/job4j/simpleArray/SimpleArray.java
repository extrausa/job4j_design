package ru.job4j.simpleArray;
// 5.2.1. Реализовать SimpleArray<T> [#455156]
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] elements;
    private int size;
    public int count = 0;

    public SimpleArray(int size) {
        this.size = size;
        elements = (T[]) new Object[size];
    }
    
    public void add (T model) {
        elements[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index - 1, count);
        elements[index - 1] = model;

    }

    public void remove(int index) {
        Objects.checkIndex(index - 1, count);
        System.arraycopy(elements, index, elements, index - 1,  size - index - 1);
    }

    public T get(int index) {
        Objects.checkIndex(index - 1, count);
        return elements[index - 1];
    }
    @Override
    public Iterator<T> iterator() {

        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < count;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[currentIndex++];
            }
        };
        return it;
    }
}
