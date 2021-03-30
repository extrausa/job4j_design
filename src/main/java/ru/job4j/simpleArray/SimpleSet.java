package ru.job4j.simpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>(16);

    @Override
    public boolean add(T value) {

        if (contains(value)) {
            return false;
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        if (set.count == 0) {
            return false;
        }

        while (set.iterator().hasNext()) {
            if (set.iterator().next().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return set.iterator().hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return set.iterator().next();
            }
        };
        return it;
    }
}
