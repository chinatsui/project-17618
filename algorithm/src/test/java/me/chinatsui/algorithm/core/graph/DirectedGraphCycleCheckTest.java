package me.chinatsui.algorithm.core.graph;

import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphCycleCheckTest {

    @Test
    public void test_function_works_on_dag() {
        Graph dag = dag();
        DirectedGraphCycleCheck check = new DirectedGraphCycleCheck(dag);
        Assert.assertFalse(check.hasCycle());

        int[] actual = check.getCycle();
        int[] expected = {};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_function_works_on_dcg() {
        Graph dcg = dcg();
        DirectedGraphCycleCheck check = new DirectedGraphCycleCheck(dcg);
        Assert.assertTrue(check.hasCycle());

        int[] actual = check.getCycle();
        int[] expected = {2, 3, 4, 5, 2};
        Assert.assertArrayEquals(expected, actual);
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
