package me.chinatsui.algorithm.core.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DepthFirstSearch {

    private final Graph graph;
    private final int src;
    private final Set<Integer> visited;
    private final int[] edgeTo;

    public DepthFirstSearch(Graph graph, int src) {
        this.graph = graph;
        this.src = src;
        visited = new HashSet<>();
        edgeTo = new int[graph.size()];
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = i;
        }
        dfs(src);
    }

    private void dfs(int v) {
        visited.add(v);

        for (int w : graph.adjacentNodes(v)) {
            if (!visited.contains(w)) {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }

    public int[] pathTo(int w) {
        LinkedList<Integer> path = new LinkedList<>();
        while (w != src) {
            path.push(w);
            w = edgeTo[w];
        }
        path.push(src);
        return Arrays.stream(path.toArray(new Integer[0])).mapToInt(i -> i).toArray();
    }
}
