package me.chinatsui.algorithm.exercise.graph;

import me.chinatsui.algorithm.exercise.graph.TopologicalSort.DirectedGraph;
import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortTest {

    @Test
    public void test() {
        DirectedGraph graph = new DirectedGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 1);
        graph.addEdge(6, 5);
        TopologicalSort ts = new TopologicalSort(graph);
        Assert.assertTrue(ts.hasCycle());
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 1}, ts.cycle().toArray(new Integer[5]));
        graph.removeEdge(4, 1);
        ts = new TopologicalSort(graph);
        Assert.assertFalse(ts.hasCycle());
        Assert.assertArrayEquals(new Integer[]{6, 1, 2, 3, 4, 5}, ts.order().toArray(new Integer[6]));
    }
}
