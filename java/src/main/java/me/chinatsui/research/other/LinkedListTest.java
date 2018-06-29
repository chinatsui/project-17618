package me.chinatsui.research.other;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test_remove_last() {
        LinkedList<Integer> list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

    @Test
    public void test_add_first_add_last() {
        LinkedList<Integer> q = new LinkedList();
        q.addFirst(0);
        q.addFirst(1);
        q.add(2);
        q.add(3);
        System.out.println(Arrays.toString(q.toArray()));
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

    @Test
    public void test_general() {
        LinkedList<Integer> q = new LinkedList();
        q.add(1);
        System.out.println("add: 1, then q = " + q);
        q.add(2);
        System.out.println("add: 2, then q = " + q);
        q.offer(3);
        System.out.println("offer: 3, then q = " + q);
        System.out.println("peek: " + q.peek() + ", then q = " + q);
        System.out.println("poll: " + q.poll() + ", then q = " + q);
        System.out.println("remove: " + q.remove() + ", then q = " + q);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test_remove_while_iterating() {
        LinkedList<Integer> q = new LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        for (Integer i : q) {
            q.remove(i);
        }
    }

}
