package ru.job4j.map;
//вершины
public class Vertex {
    public char label; // метка(наприме, 'A')
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}
