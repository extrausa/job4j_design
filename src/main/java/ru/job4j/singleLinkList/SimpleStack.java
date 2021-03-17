package ru.job4j.singleLinkList;
//4. Используя контейнер на базе связанного списка создать контейнер Stack [#455133]
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        if (linked.isEmpty()) {
            return null;
        }
        T temp = linked.deleteFirst();
        return temp;
    }

    public void push(T value) {
        linked.add(value);
    }

    public void pushEnd(T value) {
        linked.addLast(value);
    }

    public void display() {
        linked.dispalyNode();
    }
}
