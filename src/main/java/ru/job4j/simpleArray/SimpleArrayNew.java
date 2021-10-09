package ru.job4j.simpleArray;
/**1. Динамический список на массиве. [#455135]*/
import java.util.*;

public class SimpleArrayNew<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;

    private int size;
    private int modCount;

    public SimpleArrayNew(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public SimpleArrayNew() {
        this(DEFAULT_CAPACITY);

    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    public boolean add(T e) {
        modCount++;
        add(e, elementData);
        return true;
    }

    private void add(T e, Object[] elementData) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = e;
        ++size;
    }

    private Object[] grow() {
        return Arrays.copyOf(elementData, elementData.length * 2);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {

                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) elementData[currentIndex++];
            }
        };
        return it;
    }
}
