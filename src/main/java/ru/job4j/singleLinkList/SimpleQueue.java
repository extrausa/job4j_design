package ru.job4j.singleLinkList;
//5. Очередь на двух стеках [#455137]
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        int a = in.size();
        T temp;
        if (in.size() == -1) {
            throw new NoSuchElementException();
        }
        while (in.size() != -1) {
            out.push(in.pop());

        }
        temp = out.pop();
        return temp;
    }

    public void push(T value) {
        in.push(value);
    }

    public void displayIn() {
        in.display();
    }

    public void displayOut() {
        out.display();
    }
}
