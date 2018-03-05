package me.chinatsui.research.algorithm.learning.graph;


import java.util.Stack;

public class DepthFirstPath {

    private final Graph graph;
    private final int source;

    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPath(Graph g, int s) {
        this.graph = g;
        this.source = s;
        marked = new boolean[g.vCount()];
        edgeTo = new int[g.vCount()];
        dfs(s);
    }


    public boolean hasPath(int w) {
        return marked[w];
    }

    public Stack pathTo(int w) {
        if (hasPath(w)) {
            Stack path = new Stack();
            for (int i = w; i != source; i = toVertex(i)) {
                path.push(i);
            }
            path.push(source);
            return path;
        } else {
            return new Stack();
        }
    }

    public int toVertex(int v) {
        return edgeTo[v];
    }

    private void dfs(int v) {
        marked[v] = true;

        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
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
