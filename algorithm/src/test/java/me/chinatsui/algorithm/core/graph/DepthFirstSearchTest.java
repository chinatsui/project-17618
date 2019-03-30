package me.chinatsui.algorithm.core.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepthFirstSearchTest {

    private Graph graph;

    @Before
    public void setup() {
        this.graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 9);
        graph.addEdge(2, 5);
        graph.addEdge(2, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
    }

    @Test
    public void test_dfs_works_as_expected() {
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        int[] actual = dfs.pathTo(9);
        int[] expected = {0, 2, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(expected, actual);
    }
}
