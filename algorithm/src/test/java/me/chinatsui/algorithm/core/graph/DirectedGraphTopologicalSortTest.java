package me.chinatsui.algorithm.core.graph;

import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphTopologicalSortTest {

    @Test
    public void test_function_works_on_dag() {
        Graph dag = dag();
        DirectedGraphTopologicalSort sort = new DirectedGraphTopologicalSort(dag);
        int[] order = sort.order();

        int[] positions = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            positions[order[i]] = i;
        }

        Assert.assertTrue(positions[7] > positions[0]);
        Assert.assertTrue(positions[7] > positions[1]);
        Assert.assertTrue(positions[6] > positions[7]);
        Assert.assertTrue(positions[6] > positions[4]);
        Assert.assertTrue(positions[5] > positions[1]);
    }

    @Test(expected = IllegalStateException.class)
    public void test_exception_thrown_on_dct() {
        Graph dcg = dcg();
        DirectedGraphTopologicalSort sort = new DirectedGraphTopologicalSort(dcg);
        sort.order();
    }

    private Graph dag() {
        Graph dag = new Graph(8, true);
        dag.addEdge(0, 7);
        dag.addEdge(1, 2);
        dag.addEdge(2, 3);
        dag.addEdge(3, 4);
        dag.addEdge(4, 5);
        dag.addEdge(4, 6);
        dag.addEdge(1, 7);
        dag.addEdge(7, 6);
        return dag;
    }

    private Graph dcg() {
        Graph dcg = new Graph(8, true);
        dcg.addEdge(0, 7);
        dcg.addEdge(1, 2);
        dcg.addEdge(2, 3);
        dcg.addEdge(3, 4);
        dcg.addEdge(4, 5);
        dcg.addEdge(4, 6);
        dcg.addEdge(5, 2);
        dcg.addEdge(1, 7);
        dcg.addEdge(7, 6);
        return dcg;
    }
}
