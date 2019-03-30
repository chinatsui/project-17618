package me.chinatsui.algorithm.core.graph;

import java.util.LinkedHashSet;
import java.util.Set;

import net.jcip.annotations.NotThreadSafe;

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
            adj[i] = new LinkedHashSet<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        if (!directed) {
            adj[w].add(v);
        }
    }

    public Set<Integer> adjacentNodes(int v) {
        return adj[v];
    }

    public int size() {
        return adj.length;
    }
}
