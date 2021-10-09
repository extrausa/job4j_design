package ru.job4j.simpleLinkedList;
/**2. Создать контейнер на базе связанного списка [#455136]*/
import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E>, Linked<E> {
    private int size = 0;
    private int modCount;
    private Node<E> first;
    private Node<E> last;

    public SimpleLinkedList() {
        last = new Node<E>(first, null, null);
        first = new Node<E>(null, null, last);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public void setCurrentitem(E element) {
            this.item = element;
        }

        public void setNext(Node<E> last) {
            this.next = last;
        }

        public void setPrev(Node<E> first) {
            this.prev = first;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

    }

    @Override
    public void addLast(E element) {
        modCount++;
        Node<E> addLast = last;
        addLast.setCurrentitem(element);
        last = new Node<E>(addLast, null, null);
        addLast.setNext(last);
        size++;

    }

    @Override
    public void addFirst(E element) {
        modCount++;
        Node<E> addFirst = first;
        addFirst.setCurrentitem(element);
        first = new Node<E>(null, null, addFirst);
        addFirst.setPrev(first);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElement(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getItem();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNext();

    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;
            private int expectedModCount = modCount;
            private Node<E> current = first;
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                currentIndex++;
                E value = current.item;
                current = current.next;
                return value;
            }
        };

        return it;
    }

}
