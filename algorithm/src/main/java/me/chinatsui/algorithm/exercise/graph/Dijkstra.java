package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public List<Integer> shortestPath(int src, int dst) {
        int n = graph.vertexCount();

        // init predecessor and set max value for each vertex.
        int[] predecessor = new int[n];
        Vertex[] vertexes = new Vertex[n];
        for (int i = 0; i < n; i++) {
            predecessor[i] = i;
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        // init visited array and put vertex src into queue.
        boolean[] visited = new boolean[n];
        PriorityQueue pq = new PriorityQueue(n);
        pq.offer(vertexes[src]);
        vertexes[src].dist = 0;
        visited[src] = true;

        // bfs
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (cur.id == dst) {
                break;
            }

            LinkedList<Edge> edges = graph.adj[cur.id];
            for (Edge edge : edges) {
                Vertex next = vertexes[edge.dst];
                if (cur.dist + edge.weight < next.dist) {
                    next.dist = cur.dist + edge.weight;
                    if (visited[next.id]) {
                        pq.update(next);
                    } else {
                        pq.offer(next);
                        visited[next.id] = true;
                    }
                    predecessor[next.id] = cur.id;
                }
            }
        }

        // construct shortest path.
        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(src);
        constructShortestPath(shortestPath, predecessor, src, dst);
        return shortestPath;
    }

    private void constructShortestPath(List<Integer> shortestPath, int[] predecessor, int src, int dst) {
        if (src == dst) {
            return;
        }
        constructShortestPath(shortestPath, predecessor, src, predecessor[dst]);
        shortestPath.add(dst);
    }

    static class Graph {
        LinkedList<Edge>[] adj;

        Graph(int n) {
            adj = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        int vertexCount() {
            return adj.length;
        }

        void addEdge(int src, int dst, int weight) {
            this.adj[src].add(new Edge(src, dst, weight));
        }
    }

    static class Edge {
        int src;
        int dst;
        int weight;

        Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    static class Vertex {
        int id;
        int dist;

        Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    static class PriorityQueue {
        Vertex[] vertexes;
        int size;

        PriorityQueue(int n) {
            vertexes = new Vertex[n];
        }

        Vertex poll() {
            Vertex vertex;
            if (size == 0) {
                vertex = null;
            } else {
                vertex = vertexes[0];
                swap(0, size - 1);
                vertexes[--size] = null;
                sink(0, size - 1);
            }
            return vertex;
        }

        void offer(Vertex vertex) {
            if (size == vertexes.length) {
                throw new RuntimeException("The vertex in the queue has exceeds the limit.");
            } else {
                vertexes[size++] = vertex;
                swim(size - 1);
            }
        }

        void update(Vertex vertex) {
            for (int i = 0; i < size; i++) {
                if (vertexes[i].id == vertex.id) {
                    vertexes[i].dist = vertex.dist;
                    break;
                }
            }
        }

        boolean isEmpty() {
            return size == 0;
        }

        private void sink(int i, int bound) {
            int left = (i + 1) * 2 - 1;
            int right = left + 1;

            if (left == bound) {
                if (vertexes[i].dist > vertexes[left].dist) {
                    swap(i, left);
                }
            } else if (right <= bound) {
                int sm = vertexes[left].dist < vertexes[right].dist ? left : right;
                if (vertexes[i].dist > vertexes[sm].dist) {
                    swap(i, sm);
                    sink(sm, bound);
                }
            }
        }

        private void swim(int i) {
            int parent = (i - 1) / 2;
            if (vertexes[i].dist < vertexes[parent].dist) {
                swap(i, parent);
                swim(parent);
            }
        }

        private void swap(int src, int dst) {
            Vertex tmp = vertexes[src];
            vertexes[src] = vertexes[dst];
            vertexes[dst] = tmp;
        }
    }
}


