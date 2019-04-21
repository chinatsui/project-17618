package me.chinatsui.algorithm.core.linear_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedStackTest {

    LinkedStack<Integer> stack;

    @Before
    public void setup() {
        stack = new LinkedStack<>();
    }

    @Test
    public void test_function_works_as_expected() {
        stack.push(1);
        stack.push(2);
        stack.push(null);
        Assert.assertEquals(2, stack.size());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertEquals(new Integer(5), stack.pop());
        Assert.assertEquals(new Integer(4), stack.pop());
        stack.push(6);
        Assert.assertEquals(new Integer(6), stack.pop());
        Assert.assertEquals(3, stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        Assert.assertEquals(0, stack.size());
        stack.pop();
        Assert.assertEquals(0, stack.size());
    }
}
