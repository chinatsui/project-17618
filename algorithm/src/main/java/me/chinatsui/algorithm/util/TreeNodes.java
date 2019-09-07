package me.chinatsui.algorithm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;

public class TreeNodes {

    private TreeNodes() {
    }

    public static Integer[] serialize(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                traversal.add(null);
                continue;
            }

            traversal.add(node.val);
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return traversal.toArray(new Integer[0]);
    }

    public static TreeNode deserializeByLevelTraversal(Integer[] data) {
        if (data == null || data.length < 1) {
            return null;
        }

        LinkedList<Integer> traversal = new LinkedList<>(Arrays.asList(data));

        TreeNode root;
        Integer rootVal = traversal.poll();
        if (rootVal == null) {
            return null;
        } else {
            root = new TreeNode(rootVal);
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            Integer leftVal = traversal.poll();
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                node.left = left;
                queue.offer(left);
            }

            Integer rightVal = traversal.poll();
            if (rightVal != null) {
                TreeNode right = new TreeNode(rightVal);
                node.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    public static TreeNode getBinarySearchTree() {
        TreeNode root = new TreeNode(16);

        root.left = new TreeNode(8);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(15);

        return root;
    }

    public static TreeNode getSymmetricTree() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);

        return root;
    }

    public static TreeNode getFullBinaryTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);

        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(12);

        root.right.left.left = new TreeNode(13);
        root.right.left.right = new TreeNode(14);

        root.right.right.left = new TreeNode(15);
        root.right.right.right = new TreeNode(16);

        return root;
    }
}
