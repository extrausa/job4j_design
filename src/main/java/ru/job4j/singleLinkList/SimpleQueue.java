package ru.job4j.singleLinkList;
//5. Очередь на двух стеках [#455137]
import javax.security.auth.callback.CallbackHandler;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        T temp;
        //if (in.size() == 0) {
        if (in.isEmpty() && out.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (out.size() > 0) {
            temp = out.pop();
            return temp;
        }
        while (in.size() != 0) {
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
