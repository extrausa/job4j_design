package ru.job4j.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; //массив Вершин
    //private Map<K, V> vertexList;

    private int[][] adjMat; // матрица смежности

    private int nVerts; // текущее количество вершин
    private StackX thestack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        // Матрица смежности
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        thestack = new StackX();
    }

    public void addVertex(char lab, String name) { // в аргументе передается метка вершины
        vertexList[nVerts++] = new Vertex(lab, name);
    }

    // заполняется матрица смежности
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    // метод возвращает не посещеную вершину, смежную по отношению  к V
    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i; // возвращает первую найденную вершину
            }

        }
        return -1; //таких вершин нет

    }

    // обход в глубину
    public void dfs() {
        //Алоритм начинает с вершины 0
        vertexList[0].wasVisited = true; // ставим пометку что вершина посещена
        displayVertex(0);
        thestack.push(0);

        while (!thestack.isEmpty()) {
            //получение не посещеной вершин смежной с текущей

            int v = getAdjUnvisitedVertex(thestack.peek());
            if (v == -1) { // если такой вершины нет
                thestack.pop(); // элемент извлекается из стека и удалячется
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                thestack.push(v);
            }
        }
        // сброс флагов
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    @Override
    public String toString() {
        return "Graph{" +
                "MAX_VERTS=" + MAX_VERTS +
                ", vertexList=" + Arrays.toString(vertexList) +
                ", adjMat=" + Arrays.toString(adjMat) +
                ", nVerts=" + nVerts +
                '}';
    }
}
