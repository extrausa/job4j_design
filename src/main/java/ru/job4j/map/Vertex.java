package ru.job4j.map;
//вершины
public class Vertex { // он же user и e-mail
    public char label; // метка(наприме, 'A')
    public boolean wasVisited;
    public String name;
    public int numberName;

    public Vertex(char label, String name) {
        this.label = label;
        this.wasVisited = false;
        this.name = name;
    }


}
