package me.chinatsui.algorithm.exercise.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AStar {

    private Graph graph;

    public AStar(Graph graph) {
        this.graph = graph;
    }

    public List<Integer> shortestPath(int src, int dst) {
        int n = graph.vertexCount();

        // init predecessor used for shortest path construction
        int[] predecessor = new int[n];
        for (int i = 0; i < n; i++) {
            predecessor[i] = i;
        }

        // init visited array, priority queue and enqueue src vertex.
        boolean[] visited = new boolean[n];
        Vertex[] vertexes = copyVertexes(graph.vertexes);
        PriorityQueue pq = new PriorityQueue(n);
        pq.offer(vertexes[src]);
        visited[src] = true;
        vertexes[src].dist = 0;
        vertexes[src].hf = 0; // for src, we treat it as 0 on purpose.

        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            for (Edge edge : graph.adj[cur.id]) {
                Vertex next = vertexes[edge.dst];
                if (cur.dist + edge.weight < next.dist) {
                    next.dist = cur.dist + edge.weight;
                    next.hf = next.dist + ManhattanDistance(next, vertexes[dst]);
                    if (visited[next.id]) {
                        pq.update(next);
                    } else {
                        pq.offer(next);
                        visited[next.id] = true;
                    }
                    predecessor[next.id] = cur.id;
                }
                if (next.id == dst) {
                    pq.clear();
                    break;
                }
            }
        }

        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(src);
        constructShortestPath(shortestPath, predecessor, src, dst);
        return shortestPath;
    }

    private int ManhattanDistance(Vertex src, Vertex dst) {
        return Math.abs(src.x - dst.x) + Math.abs(src.y - dst.y);
    }

    private void constructShortestPath(List<Integer> shortestPath, int[] predecessor, int src, int dst) {
        if (src == dst) {
            return;
        }
        constructShortestPath(shortestPath, predecessor, src, predecessor[dst]);
        shortestPath.add(dst);
    }

    private Vertex[] copyVertexes(Vertex[] vertexes) {
        Vertex[] copies = new Vertex[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            Vertex vertex = vertexes[i];
            Vertex copy = new Vertex(vertex.id, vertex.x, vertex.y);
            copy.hf = vertex.hf;
            copy.dist = vertex.dist;
            copies[i] = copy;
        }
        return copies;
    }

    static class Graph {
        Vertex[] vertexes;
        LinkedList<Edge>[] adj;

        Graph(Vertex[] vertexes) {
            int n = vertexes.length;
            this.vertexes = vertexes;
            this.adj = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int src, int dst, int weight) {
            this.adj[src].add(new Edge(src, dst, weight));
        }

        int vertexCount() {
            return vertexes.length;
        }
    }

    static class Vertex {
        final int id;
        final int x;
        final int y;
        int hf;  // hf = g + h
        int dist;

        Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.hf = -1;
            this.dist = Integer.MAX_VALUE;
        }
    }

    static class Edge {
        final int src;
        final int dst;
        final int weight;

        Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    static class PriorityQueue {
        Vertex[] vertexes;
        int size;

        PriorityQueue(int n) {
            vertexes = new Vertex[n];
        }

        Vertex poll() {
            if (size == 0) {
                return null;
            }

            Vertex vertex = vertexes[0];
            swap(0, size - 1);
            vertexes[--size] = null;
            sink(0, size - 1);
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
                    vertexes[i].hf = vertex.hf;
                    vertexes[i].dist = vertex.dist;
                    break;
                }
            }
        }

        boolean isEmpty() {
            return size == 0;
        }

        void clear() {
            size = 0;
        }

        private void sink(int i, int bound) {
            int left = (i + 1) * 2 - 1;
            int right = left + 1;

            if (left == bound) {
                if (vertexes[i].hf > vertexes[left].hf) {
                    swap(i, left);
                }
            } else if (right <= bound) {
                int sm = vertexes[left].hf < vertexes[right].hf ? left : right;
                if (vertexes[i].hf > vertexes[sm].hf) {
                    swap(i, sm);
                    sink(sm, bound);
                }
            }
        }

        private void swim(int i) {
            int parent = (i - 1) / 2;
            if (vertexes[i].hf < vertexes[parent].hf) {
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
