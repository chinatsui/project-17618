package me.chinatsui.research.algorithm.learning.graph;

import java.util.HashSet;

public class Graph {
    private final int v;
    private int e;
    private final HashSet<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new HashSet[this.v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public boolean addEdge(int v, int w) {
        if (!adj[v].contains(w)) {
            adj[v].add(w);
            adj[w].add(v);
            e++;
            return true;
        } else {
            return false;
        }
    }

    public HashSet<Integer> adjacentList(int v) {
        return adj[v];
    }

    public int edgeSize() {
        return e;
    }

    public int vertexSize() {
        return v;
    }
}
