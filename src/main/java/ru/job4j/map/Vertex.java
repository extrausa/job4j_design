package ru.job4j.map;

import java.util.Objects;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public String name;
    public int numberName;

    public Vertex(char label, String name) {
        this.label = label;
        this.wasVisited = false;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex) o;
        return label == vertex.label && wasVisited == vertex.wasVisited && numberName == vertex.numberName && Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, wasVisited, name, numberName);
    }
}
