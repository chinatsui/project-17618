package me.chinatsui.algorithm.review.graph;


import java.util.Stack;

public class LowestCommonAncestor {

    private DepthFirstPath dfp;

    public LowestCommonAncestor(Graph graph, int vertexSrc) {
        if (!graph.isDirected()) {
            throw new IllegalArgumentException("Graph must be directed.");
        }
        dfp = new DepthFirstPath(graph, vertexSrc);
    }

    public int find(int vertexA, int vertexB) {
        Stack<Integer> lrg;
        Stack<Integer> sml;

        if (dfp.pathTo(vertexA).size() < dfp.pathTo(vertexB).size()) {
            sml = dfp.pathTo(vertexA);
            lrg = dfp.pathTo(vertexB);
        } else {
            sml = dfp.pathTo(vertexB);
            lrg = dfp.pathTo(vertexA);
        }

        if (sml.size() == 0) {
            return -1;
        }

        int offset = lrg.size() - sml.size();

        for (int i = 0; i < sml.size(); i++) {
            int ancestorSml = sml.get(i);
            int ancestorLrg = lrg.get(i + offset);
            if (ancestorSml == ancestorLrg) {
                return ancestorSml;
            }
        }

        return dfp.getStartVertex();
    }

    public static void main(String[] args) {
        Graph g = new Graph(10, true);
        g.addEdge(0, 4);
        g.addEdge(4, 7);
        g.addEdge(0, 3);
        g.addEdge(7, 9);
        g.addEdge(7, 2);

        LowestCommonAncestor lca = new LowestCommonAncestor(g, 0);
        System.out.println(lca.find(2, 9));
    }

}
