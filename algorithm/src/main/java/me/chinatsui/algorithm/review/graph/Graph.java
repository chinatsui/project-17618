package me.chinatsui.algorithm.review.graph;

import java.util.HashSet;

public class Graph {
    private boolean isDirected;
    private final int vertexCount;
    private int edgeCount = 0;
    private final HashSet<Integer>[] adjSet;

    public Graph(int count) {
        this(count, false);
    }

    public Graph(int count, boolean isDirected) {
        this.vertexCount = count;
        this.isDirected = isDirected;
        adjSet = new HashSet[count];
        for (int i = 0; i < count;) {
            adjSet[i++] = new HashSet<>();
        }
    }

    public boolean addEdge(int src, int dst) {
        if (!adjSet[src].contains(dst)) {
            adjSet[src].add(dst);
            edgeCount++;
            if (!isDirected) {
                adjSet[dst].add(src);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isDirected() {
        return isDirected;
    }

    public HashSet<Integer> adjacent(int v) {
        return adjSet[v];
    }

    public int edgeSize() {
        return edgeCount;
    }

    public int vertexSize() {
        return vertexCount;
    }
}
