package me.chinatsui.algorithm.exercise.graph;

import java.util.List;

import me.chinatsui.algorithm.exercise.graph.AStar;
import me.chinatsui.algorithm.exercise.graph.AStar.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AStarTest {

    private Graph graph;
    private AStar aStar;

    @Before
    public void setup() {
        Vertex[] vertexes = new Vertex[11];
        vertexes[0] = new Vertex(0, 320, 630);
        vertexes[1] = new Vertex(1, 300, 630);
        vertexes[2] = new Vertex(2, 280, 625);
        vertexes[3] = new Vertex(3, 270, 630);
        vertexes[4] = new Vertex(4, 320, 700);
        vertexes[5] = new Vertex(5, 360, 620);
        vertexes[6] = new Vertex(6, 320, 590);
        vertexes[7] = new Vertex(7, 370, 580);
        vertexes[8] = new Vertex(8, 350, 730);
        vertexes[9] = new Vertex(9, 390, 690);
        vertexes[10] = new Vertex(10, 400, 620);
        graph = new Graph(vertexes);
        graph.addEdge(0, 1, 20);
        graph.addEdge(0, 4, 60);
        graph.addEdge(0, 5, 60);
        graph.addEdge(0, 6, 60);
        graph.addEdge(1, 2, 20);
        graph.addEdge(2, 3, 10);
        graph.addEdge(3, 4, 80);
        graph.addEdge(3, 6, 80);
        graph.addEdge(4, 8, 50);
        graph.addEdge(8, 5, 70);
        graph.addEdge(8, 9, 50);
        graph.addEdge(9, 10, 60);
        graph.addEdge(5, 9, 80);
        graph.addEdge(5, 10, 50);
        graph.addEdge(6, 7, 70);
        graph.addEdge(7, 10, 110);
        aStar = new AStar(graph);
    }

    @Test
    public void test() {
        int[] expected = new int[]{0, 5, 10};
        List<Integer> path = aStar.shortestPath(0, 10);
        Assert.assertEquals(expected.length, path.size());
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], (int) path.get(i));
        }
    }
}
