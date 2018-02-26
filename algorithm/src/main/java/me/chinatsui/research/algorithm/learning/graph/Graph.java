package me.chinatsui.research.algorithm.learning.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chinatsui on 09/01/2018.
 */
public class Graph {

    private final int vCount;
    private int eCount;
    private Set<Integer>[] vSets;

    public Graph(int vCount) {
        this.vCount = vCount;
        vSets = new Set[this.vCount];
        for (int i = 0; i < vCount; i++) {
            vSets[i] = new HashSet<>();
        }
    }

    public boolean addEdge(int v, int w) {
        if (!vSets[v].contains(w)) {
            vSets[v].add(w);
            vSets[w].add(v);
            eCount++;
            return true;
        } else {
            return false;
        }
    }

    public Set<Integer> adj(int v) {
        return vSets[v];
    }

    public int eCount() {
        return eCount;
    }

    public int vCount() {
        return vCount;
    }

}
