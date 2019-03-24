package me.chinatsui.algorithm.core.graph;

import net.jcip.annotations.NotThreadSafe;

import java.util.HashSet;
import java.util.Set;

@NotThreadSafe
@SuppressWarnings("unchecked")
public class Graph {
    private boolean directed;
    private Set<Integer>[] adj;

    public Graph(int n) {
        this(n, false);
    }

    public Graph(int n, boolean directed) {
        this.directed = directed;
        adj = new Set[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        if (!isDirected()) {
            adj[w].add(v);
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public Set<Integer> adjacentNodes(int v) {
        return adj[v];
    }

    public int size() {
        return adj.length;
    }
}
