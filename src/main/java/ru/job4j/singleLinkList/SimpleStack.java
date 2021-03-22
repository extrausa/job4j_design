package ru.job4j.singleLinkList;

import java.util.NoSuchElementException;

//4. Используя контейнер на базе связанного списка создать контейнер Stack [#455133]
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        if (linked.isEmpty()) {
            return (T) new NoSuchElementException();
        }
        T temp = linked.deleteFirst();
        return temp;
    }

    public void push(T value) {
        linked.addFirst(value);
    }

//    public void pushEnd(T value) {
//        linked.addLast(value);
//    }
    public int size() {
        return linked.size();
    }

    public void display() {
        linked.dispalyNode();
    }
}
