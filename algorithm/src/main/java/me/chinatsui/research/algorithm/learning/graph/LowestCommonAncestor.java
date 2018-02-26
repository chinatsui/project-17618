package me.chinatsui.research.algorithm.learning.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by chinatsui on 11/01/2018.
 */
public class LowestCommonAncestor {

    private DirectedGraph directedGraph;
    private boolean[] vis;
    private int[] uf;

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 8);
        g.addEdge(8, 9);

        LowestCommonAncestor lca = new LowestCommonAncestor(g);
        int result = lca.findLCA(6, 8);
        System.out.println(result);
    }

    public LowestCommonAncestor(DirectedGraph g) {
        this.directedGraph = g;
        vis = new boolean[g.vCount()];
        uf = new int[g.vCount()];

        for (int i = 0; i < directedGraph.vCount; i++) {
            uf[i] = i;
        }
    }

    public int findLCA(int v, int w) {
        reset();
        Map<String, Integer> results = new HashMap();
        dfs(0, v, w, results);
        return results.get(v + "-" + w);
    }

    private void reset() {
        for (int i = 0; i < directedGraph.vCount; i++) {
            vis[i] = false;
            uf[i] = i;
        }
    }

    private void dfs(int s, int v, int w, Map<String, Integer> results) {
        if (directedGraph.hasAdj(s)) {
            for (int d : directedGraph.adj(s)) {
                dfs(d, v, w, results);
                uf[d] = s;
            }
            vis[s] = true;
        } else {
            vis[s] = true;
            if (s == v && vis[w]) {
                results.put(v + "-" + w, find(w));
            } else if (s == w && vis[v]) {
                results.put(v + "-" + w, find(v));
            }
        }
    }

    private int find(int v) {
        int result = v;
        while (result != uf[result]) {
            result = uf[result];
        }
        return result;
    }


    static class DirectedGraph {

        private int vCount;
        private int eCount;

        private Set<Integer>[] vSets;

        public DirectedGraph(int vCount) {
            this.vCount = vCount;
            vSets = new Set[vCount];

            for (int i = 0; i < vCount; i++) {
                vSets[i] = new HashSet<>();
            }
        }


        public Set<Integer> adj(int v) {
            return vSets[v];
        }

        public boolean hasAdj(int v) {
            return vSets[v].size() > 0;
        }

        public void addEdge(int v, int w) {
            eCount++;
            vSets[v].add(w);
        }

        public int vCount() {
            return vCount;
        }

        public int eCount() {
            return eCount;
        }

    }

}
