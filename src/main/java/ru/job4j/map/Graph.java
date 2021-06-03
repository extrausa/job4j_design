package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class Graph<K, V> {
    private final int MAX_VERTS = 20;
    //private Vertex[] vertexList; //массив Вершин
    private Map<K, V> vertexList;

    private int[][] adjMat; // матрица смежности

    private int nVerts; // текущее количество вершин

    public Graph(HashMap<K, V> vertex) {
        this.vertexList = vertex;
        // Матрица смежности
        this.adjMat = new int[vertexList.size()][vertexList.size()];
        this.nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }
}
