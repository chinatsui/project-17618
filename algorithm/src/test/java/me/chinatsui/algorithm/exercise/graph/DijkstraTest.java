package me.chinatsui.algorithm.exercise.graph;

import java.util.List;

import me.chinatsui.algorithm.exercise.graph.Dijkstra.Edge;
import me.chinatsui.algorithm.exercise.graph.Dijkstra.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {

    private Graph graph;
    private Dijkstra dijkstra;

    @Before
    public void setup() {
        graph = new Graph(10);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 6, 30);
        graph.addEdge(0, 3, 4);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 2);
        graph.addEdge(5, 7, 3);
        graph.addEdge(7, 8, 1);
        graph.addEdge(8, 6, 2);
        dijkstra = new Dijkstra(graph);
    }

    @Test
    public void test() {
        int[] expected = new int[]{0, 3, 4, 5, 7, 8, 6};
        List<Integer> path = dijkstra.shortestPath(0, 6);
        Assert.assertEquals(expected.length, path.size());
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], (int) path.get(i));
        }
    }
}
