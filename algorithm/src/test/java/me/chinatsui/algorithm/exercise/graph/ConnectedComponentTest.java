package me.chinatsui.algorithm.exercise.graph;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.exercise.graph.ConnectedComponent.Graph;

public class ConnectedComponentTest {

    @Test
    public void test() {
        Graph graph = new Graph(10);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);

        ConnectedComponent cc = new ConnectedComponent(graph);
        Assert.assertEquals(3, cc.size());
        Assert.assertTrue(cc.connected(2, 4));
        Assert.assertTrue(cc.connected(5, 6));
        Assert.assertFalse(cc.connected(2, 5));
        Assert.assertFalse(cc.connected(5, 8));
        Assert.assertEquals(0, cc.id(3));
    }
}
