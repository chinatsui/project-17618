package me.chinatsui.algorithm.core.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DirectedGraphTopologicalSort {

    private final Graph graph;
    private final Set<Integer> visited;
    private boolean hasCycle;
    private final Set<Integer> track;
    private final LinkedList<Integer> order;

    public DirectedGraphTopologicalSort(Graph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.track = new HashSet<>();
        this.order = new LinkedList<>();

        for (int v = 0; v < graph.size(); v++) {
            if (!visited.contains(v)) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited.add(v);
        track.add(v);

        for (int w : graph.adjacentNodes(v)) {
            if (hasCycle) {
                return;
            }

            if (!visited.contains(w)) {
                dfs(w);
            } else if (track.contains(w)) {
                hasCycle = true;
                return;
            }
        }

        track.remove(v);
        order.push(v);
    }

    public int[] order() {
        if (hasCycle) {
            throw new IllegalStateException("Cycle found.");
        } else {
            return Arrays.stream(order.toArray(new Integer[0])).mapToInt(i -> i).toArray();
        }
    }
}
