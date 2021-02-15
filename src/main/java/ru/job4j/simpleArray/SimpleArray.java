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

    public SimpleArray(int size) {
        this.size = size;
        elements = (T[]) new Object[size];
    }
    
    private int indexOfNull(T[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }
    
    public void add (T model) {
        int number = indexOfNull(elements);
        if (number > -1) {
            elements[number] = model;
        } else {
            elements[number] = null;
        }
    }

    public void set(int index, T model) {
        int size = elements.length;
        Objects.checkIndex(index - 1, size);
        elements[index - 1] = model;

    }

    public void remove(int index) {
        T[] arrayNew = (T[]) new Object[elements.length - 1];
        System.arraycopy(elements, 0, arrayNew, 0, index - 1);
        System.arraycopy(elements, (index - 1) + 1, arrayNew, index - 1, elements.length - (index - 1) - 1);
        elements = arrayNew;
    }

    public T get(int index) {
        Objects.checkIndex(index - 1, size);
        return elements[index - 1];
    }
    @Override
    public Iterator<T> iterator() {

        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < elements.length;
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
