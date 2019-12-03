package me.chinatsui.algorithm.exercise.graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectedComponent {

    private Graph graph;
    private int[] ids;
    private int count;

    public ConnectedComponent(Graph graph) {
        this.graph = graph;
        int n = graph.size();
        boolean[] visited = new boolean[n];
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = graph.adjSet[i] != null ? i : -1;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph.adjSet[i] != null) {
                dfs(i, visited);
                count++;
            }
        }
    }

    private void dfs(int src, boolean[] visited) {
        visited[src] = true;
        ids[src] = count;
        Set<Integer> adjSet = graph.adjSet[src];
        if (adjSet != null) {
            for (int adj : adjSet) {
                if (!visited[adj]) {
                    dfs(adj, visited);
                }
            }
        }
    }

    public int size() {
        return count;
    }

    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

    public int id(int p) {
        return ids[p];
    }

    static class Graph {
        Set<Integer>[] adjSet;

        Graph(int size) {
            adjSet = new Set[size];
        }

        int size() {
            return adjSet.length;
        }

        void addEdge(int src, int dst) {
            if (adjSet[src] == null) {
                adjSet[src] = new HashSet<>();
            }
            adjSet[src].add(dst);

            if (adjSet[dst] == null) {
                adjSet[dst] = new HashSet<>();
            }
            adjSet[dst].add(src);
        }

        void removeEdge(int src, int dst) {
            if (adjSet[src] != null) {
                adjSet[src].remove(dst);
            }

            if (adjSet[dst] != null) {
                adjSet[dst].remove(src);
            }
        }
    }
}
