package me.chinatsui.algorithm.core.linear_list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {

    ArrayStack<Integer> stack;

    @Before
    public void setup() {
        stack = new ArrayStack<>(5);
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
        stack.push(6);
        Assert.assertEquals(6, stack.size());
        Assert.assertEquals(new Integer(6), stack.pop());
        stack.pop();
        stack.pop();
        stack.pop();
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals(new Integer(2), stack.pop());
        Assert.assertEquals(1, stack.size());
    }
}
