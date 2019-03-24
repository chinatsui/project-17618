package me.chinatsui.algorithm.core.graph;

import net.jcip.annotations.NotThreadSafe;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

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

        dfs(0);
    }

    private void dfs(int v) {
        visited.add(v);
        track.add(v);

        for (int w : graph.adjacentNodes(v)) {
            if (cycleFound) {
                return;
            }

            if (!visited.contains(w)) {
                dfs(w);
                edgeTo[w] = v;
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

    public LinkedList<Integer> getCycle() {
        return cycle;
    }
}
