package me.chinatsui.algorithm.core.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class DirectedGraphCycleCheck {

    private Graph graph;
    private boolean cycleFound;
    private Set<Integer> visited;
    private Set<Integer> track;
    private LinkedList<Integer> cycle;
    private int[] edgeTo;

    public DirectedGraphCycleCheck(Graph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.track = new HashSet<>();
        edgeTo = new int[graph.size()];

        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = i;
        }

        for (int v = 0; v < graph.size(); v++) {
            if (!this.visited.contains(v)) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        visited.add(v);
        track.add(v);

        for (int w : graph.adjacentNodes(v)) {
            if (cycleFound) {
                return;
            }

            if (!visited.contains(w)) {
                edgeTo[w] = v;
                dfs(w);
            } else if (track.contains(w)) {
                cycleFound = true;
                cycle = new LinkedList<>();
                cycle.push(w);
                int p = v;
                while (p != w) {
                    cycle.push(p);
                    p = edgeTo[p];
                }
                cycle.push(w);
                return;
            }
        }

        track.remove(v);
    }

    public boolean hasCycle() {
        return cycleFound;
    }

    public int[] getCycle() {
        if (cycle == null) {
            return new int[0];
        }
        int n = cycle.size();
        return IntStream.range(0, n).map(i -> cycle.get(i)).toArray();
    }
}
