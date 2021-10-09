package ru.job4j.forwardLinked;
/**6. Перевернуть связанный список [#455138]*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    int count = 0;

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            count++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        count++;
    }

    public boolean revert() {
        if (isEmpty() || count == 1) {
            return false;
        }
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return true;
    }

    public void display() {
        System.out.println("Node (first --> last): ");
        Node<T> current = head;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public void displayNode() {
            System.out.println("{" + value + "}");
        }
    }
}
