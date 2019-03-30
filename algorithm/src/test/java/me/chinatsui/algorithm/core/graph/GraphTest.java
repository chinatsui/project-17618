package me.chinatsui.algorithm.core.graph;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    @Test
    public void test_undirected_graph_works_as_expected() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(1, 0);

        Assert.assertEquals(10, graph.size());

        Set<Integer> adj_0 = graph.adjacentNodes(0);
        Assert.assertEquals(3, adj_0.size());
        Assert.assertTrue(adj_0.contains(2));
        Assert.assertTrue(adj_0.contains(3));
        Assert.assertTrue(adj_0.contains(1));

        Set<Integer> adj_1 = graph.adjacentNodes(1);
        Assert.assertEquals(2, adj_1.size());
        Assert.assertTrue(adj_1.contains(0));
        Assert.assertTrue(adj_1.contains(3));

        Set<Integer> adj_2 = graph.adjacentNodes(2);
        Assert.assertEquals(1, adj_2.size());
        Assert.assertTrue(adj_2.contains(0));

        Set<Integer> adj_3 = graph.adjacentNodes(3);
        Assert.assertEquals(2, adj_3.size());
        Assert.assertTrue(adj_3.contains(0));
        Assert.assertTrue(adj_3.contains(1));
    }

    @Test
    public void test_directed_graph_works_as_expected() {
        Graph graph = new Graph(10, true);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(1, 0);

        Assert.assertEquals(10, graph.size());

        Set<Integer> adj_0 = graph.adjacentNodes(0);
        Assert.assertEquals(2, adj_0.size());
        Assert.assertTrue(adj_0.contains(2));
        Assert.assertTrue(adj_0.contains(3));

        Set<Integer> adj_1 = graph.adjacentNodes(1);
        Assert.assertEquals(1, adj_1.size());
        Assert.assertTrue(adj_1.contains(0));

        Set<Integer> adj_2 = graph.adjacentNodes(2);
        Assert.assertEquals(0, adj_2.size());

        Set<Integer> adj_3 = graph.adjacentNodes(3);
        Assert.assertEquals(1, adj_3.size());
        Assert.assertTrue(adj_3.contains(1));
    }
}
