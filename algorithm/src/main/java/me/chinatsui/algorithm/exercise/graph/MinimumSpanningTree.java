package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import me.chinatsui.algorithm.entity.UnionFind.WeightedQuickUnionUF;

public abstract class MinimumSpanningTree {

    protected WeightedUndirectedGraph graph;
    protected int n;
    protected List<Edge> edgeList;
    protected PriorityQueue<Edge> minPQ;
    protected int weight;

    public MinimumSpanningTree(WeightedUndirectedGraph graph) {
        this.graph = graph;
        this.n = graph.size;
        edgeList = new ArrayList<>();
        minPQ = new PriorityQueue<>();
    }

    public List<Edge> edges() {
        return edgeList;
    }

    public int weight() {
        return weight;
    }

    public int size() {
        return edgeList.size();
    }

    static class KruskalMST extends MinimumSpanningTree {

        private WeightedQuickUnionUF unionFind;

        public KruskalMST(WeightedUndirectedGraph graph) {
            super(graph);
            unionFind = new WeightedQuickUnionUF(n);

            for (Edge edge : graph.edges()) {
                minPQ.offer(edge);
            }

            while (!minPQ.isEmpty() && size() < n - 1) {
                Edge edge = minPQ.poll();
                int v = edge.either(), w = edge.other(v);

                if (unionFind.connected(v, w)) {
                    continue;
                }

                unionFind.union(v, w);
                edgeList.add(edge);
                weight += edge.weight;
            }
        }
    }

    static class PrimMST extends MinimumSpanningTree {

        private boolean[] visited;

        public PrimMST(WeightedUndirectedGraph graph) {
            super(graph);
            visited = new boolean[n];

            explore(0);
            while (!minPQ.isEmpty()) {
                // get the shortest edge from the min queue
                Edge edge = minPQ.poll();

                int v = edge.either(), w = edge.other(v);

                // if its two vertexes are both visited, then skip it
                if (visited[v] && visited[w]) {
                    continue;
                }

                // otherwise it must be part of a MST
                edgeList.add(edge);
                weight += edge.weight;

                if (!visited[v]) {
                    explore(v);
                }

                if (!visited[w]) {
                    explore(w);
                }
            }
        }

        private void explore(int v) {
            visited[v] = true;

            // add all adjacent edges whose other vertex is not visited into min queue
            for (Edge adj : graph.adjSet[v]) {
                if (!visited[adj.other(v)]) {
                    minPQ.offer(adj);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    static class WeightedUndirectedGraph {
        Set<Edge>[] adjSet;
        int size;

        WeightedUndirectedGraph(int n) {
            size = n;
            adjSet = new Set[n];
            for (int i = 0; i < n; i++) {
                adjSet[i] = new HashSet<>();
            }
        }

        void addEdge(Edge edge) {
            int v = edge.either();
            int w = edge.other(v);
            adjSet[v].add(edge);
            adjSet[w].add(edge);
        }

        List<Edge> edges() {
            List<Edge> edges = new ArrayList<>();
            for (int v = 0; v < size; v++) {
                for (Edge edge : adjSet[v]) {
                    int w = edge.other(v);
                    if (v < w) {
                        edges.add(edge);
                    }
                }
            }
            return edges;
        }
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int w;
        int weight;

        int either() {
            return v;
        }

        int other(int v) {
            if (this.v == v) {
                return this.w;
            } else if (this.w == v) {
                return this.v;
            } else {
                throw new IllegalArgumentException();
            }
        }

        Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.weight < other.weight) {
                return -1;
            } else if (this.weight > other.weight) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
