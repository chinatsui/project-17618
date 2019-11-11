package me.chinatsui.algorithm.exercise.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    private DirectedGraph graph;
    private boolean[] visited;
    private Stack<Integer> onStack;
    private int[] predecessor;
    private LinkedList<Integer> cycle;
    private LinkedList<Integer> order;

    TopologicalSort(DirectedGraph graph) {
        this.graph = graph;
        int n = graph.size();
        visited = new boolean[n];
        onStack = new Stack<>();

        predecessor = new int[n];
        for (int i = 0; i < n; i++) {
            predecessor[i] = i;
        }

        order = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            if (!hasCycle() && graph.adjSet[i] != null) {
                dfs(i);
            }
        }
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public LinkedList<Integer> cycle() {
        return cycle;
    }

    public LinkedList<Integer> order() {
        return order;
    }

    private void dfs(int src) {
        visited[src] = true;
        onStack.push(src);
        Set<Integer> adjSet = graph.adjSet[src];
        if (adjSet != null) {
            for (int adj : adjSet) {
                if (hasCycle()) {
                    return;
                }

                if (!visited[adj]) {
                    predecessor[adj] = src;
                    dfs(adj);
                } else if (onStack.contains(adj)) {
                    cycle = new LinkedList<>();
                    cycle.push(adj);
                    int cur = src;
                    while (cur != adj) {
                        cycle.push(cur);
                        cur = predecessor[cur];
                    }
                    cycle.push(cur);
                    return;
                }
            }
        }
        onStack.pop();
        order.push(src);
    }

    @SuppressWarnings("unchecked")
    static class DirectedGraph {
        Set<Integer>[] adjSet;

        DirectedGraph(int size) {
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
        }

        void removeEdge(int src, int dst) {
            if (adjSet[src] != null) {
                adjSet[src].remove(dst);
            }
        }
    }
}
