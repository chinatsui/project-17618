package me.chinatsui.algorithm.core.linear_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedQueueTest {

    Queue<Integer> queue;

    @Before
    public void setup() {
        queue = new LinkedQueue<>();
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
        Assert.assertEquals(5, queue.size());
        Assert.assertEquals(new Integer(3), queue.poll());
        Assert.assertEquals(new Integer(4), queue.poll());
        Assert.assertEquals(new Integer(5), queue.poll());
        Assert.assertEquals(new Integer(6), queue.poll());
        Assert.assertEquals(new Integer(7), queue.poll());
        Assert.assertNull(queue.poll());
    }
}
