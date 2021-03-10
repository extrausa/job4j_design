package ru.job4j.simpleLinkedList;

public interface Linked<E> extends Iterable<E> {

    void addLast(E element);

    void addFirst(E element);

    int size();

    E getElement(int index);

}
