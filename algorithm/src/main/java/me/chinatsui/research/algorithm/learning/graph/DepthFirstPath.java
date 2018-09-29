package me.chinatsui.research.algorithm.learning.graph;

import java.util.Stack;

public class DepthFirstPath {
    private final Graph graph;
    private final int startVertex;
    private boolean[] marked;
    private int[] vertexTo;

    public DepthFirstPath(Graph g, int s) {
        this.graph = g;
        this.startVertex = s;
        marked = new boolean[g.vertexSize()];
        vertexTo = new int[g.vertexSize()];
        dfs(s);
    }

    public int getStartVertex() {
        return startVertex;
    }

    public boolean hasPath(int w) {
        return marked[w];
    }

    public Stack pathTo(int w) {
        if (hasPath(w)) {
            Stack path = new Stack();
            for (int i = w; i != startVertex; i = vertexTo(i)) {
                path.push(i);
            }
            path.push(startVertex);
            return path;
        } else {
            return new Stack();
        }
    }

    public int vertexTo(int v) {
        return vertexTo[v];
    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w : graph.adjacent(v)) {
            if (!marked[w]) {
                vertexTo[w] = v;
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0, 4);
        g.addEdge(4, 7);
        g.addEdge(3, 4);
        g.addEdge(7, 9);

        DepthFirstPath dfp = new DepthFirstPath(g, 0);

        Stack stack = dfp.pathTo(9);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
