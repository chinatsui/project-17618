package me.chinatsui.research.algorithm.learning.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPath {
    private Graph graph;
    private int source;
    private boolean[] marked;
    private int[] edgeTo;

    public BreadthFirstPath(Graph g, int s) {
        this.graph = g;
        this.source = s;
        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;

            for (int w : graph.adjacentList(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    edgeTo[w] = v;
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
            for (int i = w; i != source; i = edgeTo[i]) {
                stack.push(i);
            }
            stack.push(source);
            return stack;
        } else {
            return new Stack();
        }

    }

}
