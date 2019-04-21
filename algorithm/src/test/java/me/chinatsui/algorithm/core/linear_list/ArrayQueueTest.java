package me.chinatsui.algorithm.core.linear_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {

    Queue<Integer> queue;

    @Before
    public void setup() {
        queue = new ArrayQueue<>(5);
    }

    @Test
    public void test_function_works() {
        Assert.assertNull(queue.poll());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals(new Integer(1), queue.poll());
        queue.offer(4);
        Assert.assertEquals(new Integer(2), queue.poll());
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        Assert.assertFalse(queue.offer(8));
        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(new Integer(3), queue.poll());
        Assert.assertTrue(queue.offer(8));
    }
}
