package me.chinatsui.research.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    Stack<Integer> s = new Stack();

    @Before
    public void setup() {
        s.push(1);
        s.push(2);
        s.push(3);
    }

    @Test
    public void test_while_pop_is_filo() {
        Integer i = 3;
        while (!s.empty()) {
            Assert.assertEquals(i--, s.pop());
        }
    }

    @Test
    public void test_iteration_is_fifo(){
        Integer i = 1;
        for (Integer elem : s) {
            Assert.assertEquals(i++, elem);
        }
    }

    @Test
    public void test_copy_to_list() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(s);
        System.out.println(list);
    }

}
