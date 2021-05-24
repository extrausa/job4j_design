package ru.job4j.map;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList; //массив Вершин

    private int[][] adjMat; // матрица смежности

    private int nVerts; // текущее количество вершин

    public Graph() {
        this.vertexList = new Vertex[MAX_VERTS];
        // Матрица смежности
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }
}
