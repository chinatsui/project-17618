package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CloneTest {

    @Test
    public void test_object_clone_is_shallow_copy() {
        Node node = new Node(1);
        Node copy = node.clone();
        Assert.assertTrue(node.val == copy.val);
        Assert.assertTrue(node != copy);
        Assert.assertTrue(node.obj == copy.obj);
    }

    @Test
    public void test_array_clone_is_shallow_copy() {
        Node[] arr = {new Node(1), new Node(2), new Node(3)};
        Node[] copy = arr.clone();

        Assert.assertTrue(arr != copy);
        Assert.assertTrue(arr[0] == copy[0]);
    }

    @Test
    public void test_collection_clone_is_shallow_copy() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        ArrayList<Node> list = new ArrayList();
        list.add(n1);
        list.add(n2);
        list.add(n3);

        ArrayList<Node> copy = (ArrayList<Node>) (list).clone();
        Assert.assertTrue(list.size() == copy.size());
        Assert.assertTrue(list != copy);
        Assert.assertTrue(list.get(0).val == copy.get(0).val);
        Assert.assertTrue(list.get(0) == copy.get(0));
    }

    static class Node implements Cloneable {

        int val;
        final Object obj;

        public Node(int val) {
            this.val = val;
            obj = new Object();
        }

        @Override
        public Node clone() {
            try {
                return (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new InternalError(e);
            }
        }

    }

}
