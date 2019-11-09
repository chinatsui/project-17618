package me.chinatsui.algorithm.exercise.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Dijkstra {

    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public List<Integer> shortestPath(int src, int dst) {
        int n = graph.count();

        int[] predecessor = new int[n];
        // Use array to main path node for distance update in runtime.
        PathNode[] pathNodes = new PathNode[n];

        // init predecessor and set max value for distance of each path node.
        for (int i = 0; i < n; i++) {
            predecessor[i] = i;
            pathNodes[i] = new PathNode(i, Integer.MAX_VALUE);
        }

        // init visited array and put vertex src into queue.
        boolean[] visited = new boolean[n];
        PriorityQueue pq = new PriorityQueue(n);
        pq.offer(pathNodes[src]);
        pathNodes[src].dist = 0;
        visited[src] = true;

        // bfs
        while (!pq.isEmpty()) {
            PathNode cur = pq.poll();

            if (cur.id == dst) {
                break;
            }

            HashMap<Integer, Edge> edges = graph.adj[cur.id];
            for (Map.Entry<Integer, Edge> entry : edges.entrySet()) {
                Edge edge = entry.getValue();
                PathNode adj = pathNodes[edge.dst];

                // Found a shorter path to the dst path node, so update it.
                if (cur.dist + edge.weight < adj.dist) {
                    adj.dist = cur.dist + edge.weight;
                    if (visited[adj.id]) {
                        pq.update(adj);
                    } else {
                        pq.offer(adj);
                        visited[adj.id] = true;
                    }
                    predecessor[adj.id] = cur.id;
                }
            }
        }

        return buildPath(predecessor, src, dst);
    }

    private LinkedList buildPath(int[] predecessor, int src, int dst) {
        LinkedList<Integer> path = new LinkedList<>();
        while (dst != src) {
            path.push(dst);
            dst = predecessor[dst];
        }
        path.push(dst);
        return path;
    }

    static class Graph {
        // use HashMap to replace the latest edge for the same dst
        HashMap<Integer, Edge>[] adj;

        Graph(int n) {
            adj = new HashMap[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new HashMap<>();
            }
        }

        int count() {
            return adj.length;
        }

        void addEdge(int src, int dst, int weight) {
            adj[src].put(dst, new Edge(src, dst, weight));
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

    static class PathNode {
        int id;
        int dist;

        PathNode(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    static class PriorityQueue {
        PathNode[] pathNodes;
        int size;

        PriorityQueue(int n) {
            pathNodes = new PathNode[n];
        }

        PathNode poll() {
            PathNode pathNode;
            if (size == 0) {
                pathNode = null;
            } else {
                pathNode = pathNodes[0];
                swap(0, size - 1);
                pathNodes[--size] = null;
                sink(0, size - 1);
            }
            return pathNode;
        }

        void offer(PathNode pathNode) {
            if (size == pathNodes.length) {
                throw new RuntimeException("The pathNode in the queue has exceeds the limit.");
            } else {
                pathNodes[size++] = pathNode;
                swim(size - 1);
            }
        }

        void update(PathNode pathNode) {
            for (int i = 0; i < size; i++) {
                if (pathNodes[i].id == pathNode.id) {
                    pathNodes[i].dist = pathNode.dist;
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
                if (pathNodes[i].dist > pathNodes[left].dist) {
                    swap(i, left);
                }
            } else if (right <= bound) {
                int sm = pathNodes[left].dist < pathNodes[right].dist ? left : right;
                if (pathNodes[i].dist > pathNodes[sm].dist) {
                    swap(i, sm);
                    sink(sm, bound);
                }
            }
        }

        private void swim(int i) {
            int parent = (i - 1) / 2;
            if (pathNodes[i].dist < pathNodes[parent].dist) {
                swap(i, parent);
                swim(parent);
            }
        }

        private void swap(int src, int dst) {
            PathNode tmp = pathNodes[src];
            pathNodes[src] = pathNodes[dst];
            pathNodes[dst] = tmp;
        }
    }
}


