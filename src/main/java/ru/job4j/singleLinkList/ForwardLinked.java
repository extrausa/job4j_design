package ru.job4j.singleLinkList;
//3. Удалить head в односвязном списке. [#455132]
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    int count = -1;

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return count;
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
        count++;
        tail.next = node;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            count++;
            return;
        }
        count++;
        node.next = head;
        head = node;

//        Node<T> tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        tail.next = node;
    }

    public T deleteFirst() {
       Node<T> first = head;
       if (isEmpty()) {
           throw new NoSuchElementException();
       } else {
           head = head.next;
       }
       count--;
       return first.value;
    }

//    public void addLast(T value) {
//        Node<T> node = new Node<T>(value, null);
//        //Node<T> tail = head;
//        if (isEmpty()) {
//            head = node;
//            return;
//        }
//        while (head.next != null) {
//
//            if (head.next == null) {
//                head.next = node;
//                head = head.next;
//                return;
//            }
//            head = head.next;
//        }
//    }
//
//    public  T deleteLast() {
//        Node<T> temp = head.next;
//        return null;
//    }

    public void dispalyNode() {
        System.out.println("Node (first --> last): ");
        Node<T> current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println("");
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public void display() {
            System.out.println("{" + value + "}");
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
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
        return it;
    }
}
