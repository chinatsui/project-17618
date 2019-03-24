package me.chinatsui.algorithm.core.graph;

import net.jcip.annotations.NotThreadSafe;

import java.util.*;
import java.util.stream.IntStream;

@NotThreadSafe
public class GraphTraverse {

    private Graph graph;

    public GraphTraverse(Graph graph) {
        this.graph = graph;
    }

    public int[] dfs(int src, int dst) {
        int[] edgeTo = new int[graph.size()];

        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = i;
        }

        Set<Integer> visited = new HashSet<>();
        dfs(edgeTo, visited, src, dst);

        return buildPath(edgeTo, src, dst);
    }

    private void dfs(int[] edgeTo, Set<Integer> visited, int v, int dst) {
        visited.add(v);

        if (v == dst) {
            return;
        }

        for (int w : graph.adjacentNodes(v)) {
            if (visited.contains(dst)) {
                return;
            }

            if (!visited.contains(w)) {
                edgeTo[w] = v;
                dfs(edgeTo, visited, w, dst);
            }
        }
    }

    public int[] bfs(int src, int dst) {
        Set<Integer> visited = new HashSet<>();
        int[] edgeTo = new int[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            visited.add(v);

            if (v == dst) {
                break;
            }

            for (int w : graph.adjacentNodes(v)) {
                if (!visited.contains(w)) {
                    edgeTo[w] = v;
                    queue.offer(w);
                }
            }
        }

        return buildPath(edgeTo, src, dst);
    }

    private int[] buildPath(int[] edgeTo, int src, int dst) {
        int k = dst;
        ArrayList<Integer> path = new ArrayList<>();
        while (k != src) {
            path.add(k);
            k = edgeTo[k];
        }
        path.add(src);
        return IntStream.range(0, path.size() - 1).map(i -> path.get(path.size() - 1 - i)).toArray();
    }
}
