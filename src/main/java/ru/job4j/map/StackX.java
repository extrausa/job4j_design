package ru.job4j.map;
//Обход в глубину
public class StackX {
    private final int size = 20;
    private int[] st;
    private int top;

    public StackX() {
        this.st = new int[size];
        top = -1;
    }
    //разщмещение элемента в стэке

    public void push(int j) {
        st[++top] = j;
    }

    //извлечение элемента из стека

    public int pop() {
        return st[top--];
    }

    //чтение с вершины стека

    public int peek() {
        return st[top];
    }

    // true если стек пуст

    public boolean isEmpty() {
        return (top == -1);
    }
}
