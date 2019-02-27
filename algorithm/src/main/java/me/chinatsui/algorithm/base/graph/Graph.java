package me.chinatsui.algorithm.base.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Graph {
    int N;
    private boolean directed;
    private Set<Integer>[] adj;

    Graph(int n) {
        this(n, false);
    }

    Graph(int n, boolean directed) {
        this.N = n;
        this.directed = directed;
        adj = new Set[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new HashSet<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        if (!directed) {
            adj[w].add(v);
        }
    }

    class Traverse {
        int src;
        Set<Integer> visited;
        Map<Integer, Integer> toFrom;

        Traverse(int src) {
            this.src = src;
            visited = new HashSet<>();
            toFrom = new HashMap<>();
        }

        Traverse dfs() {
            dfs(src);
            return this;
        }

        Traverse bfs() {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(src);
            visited.add(src);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w : adj[v]) {
                    if (!visited.contains(w)) {
                        toFrom.put(w, v);
                        queue.offer(w);
                        visited.add(w);
                    }
                }
            }
            return this;
        }

        private void dfs(int v) {
            visited.add(v);
            for (int w : adj[v]) {
                if (!visited.contains(w)) {
                    toFrom.put(w, v);
                    dfs(w);
                }
            }
        }

        Integer[] pathTo(int dst) {
            ArrayList<Integer> path = new ArrayList<>();
            while (src != dst) {
                path.add(dst);
                dst = toFrom.get(dst);
            }
            path.add(src);
            Collections.reverse(path);
            return path.toArray(new Integer[path.size()]);
        }
    }

    class CycleCheck {
        boolean hasCycle;
        Set<Integer> visited;
        Stack<Integer> onStack;

        CycleCheck() {
            visited = new HashSet<>();
            onStack = new Stack<>();
            for (int i = 0; i < N; i++) {
                if (!visited.contains(i)) {
                    dfs(i);
                }
            }
        }

        private void dfs(int v) {
            if (hasCycle) {
                return;
            }

            visited.add(v);
            onStack.push(v);

            for (int w : adj[v]) {
                if (!visited.contains(w)) {
                    dfs(w);
                } else if (onStack.contains(w)) {
                    hasCycle = true;
                    return;
                }
            }

            onStack.clear();
        }
    }
}
