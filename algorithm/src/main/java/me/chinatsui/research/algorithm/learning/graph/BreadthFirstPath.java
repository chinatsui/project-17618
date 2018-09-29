package me.chinatsui.research.algorithm.learning.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
    private Graph graph;
    private int startVertex;
    private boolean[] marked;
    private int[] vertexTo;

    public BreadthFirstPath(Graph g, int s) {
        this.graph = g;
        this.startVertex = s;
        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;

            for (int w : graph.adjacent(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    vertexTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Stack pathTo(int w) {
        if (hasPathTo(w)) {
            Stack<Integer> stack = new Stack();
            for (int i = w; i != startVertex; i = vertexTo[i]) {
                stack.push(i);
            }
            stack.push(startVertex);
            return stack;
        } else {
            return new Stack();
        }

    }

}
