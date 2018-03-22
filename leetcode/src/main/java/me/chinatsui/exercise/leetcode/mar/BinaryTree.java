package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public enum BinaryTree {

    INSTANCE;

    public static void main(String[] args) {
//        INSTANCE.traverseByLevelOrder(getFullBinaryTree());
//        INSTANCE.traverseByColumnOrder(getFullBinaryTree());
        INSTANCE.isSymmetric(getSymmetricTree());
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null) {
            return left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }

        return false;
    }

    public void traverseByLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> traverseHistory = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            traverseHistory.add(node);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        System.out.println(Arrays.toString(traverseHistory.toArray()));
    }

    public void traverseByColumnOrder(TreeNode root) {
        TreeMap<Integer, List<TreeNode>> traverseHistory = new TreeMap();
        traverseByColumnOrder(root, 0, traverseHistory);

        System.out.print("Column Order: ");
        for (Map.Entry<Integer, List<TreeNode>> entry : traverseHistory.entrySet()) {
            for (TreeNode node : entry.getValue()) {
                System.out.print(node.val + " ");
            }
        }
        System.out.println();
    }

    private void traverseByColumnOrder(TreeNode node,
                                       int index,
                                       TreeMap<Integer, List<TreeNode>> traverseHistory) {
        if (node != null) {
            traverseHistory.putIfAbsent(index, new ArrayList<>());
            traverseHistory.get(index).add(node);

            if (node.left != null) {
                traverseByColumnOrder(node.left, index - 1, traverseHistory);
            }

            if (node.right != null) {
                traverseByColumnOrder(node.right, index + 1, traverseHistory);
            }
        }
    }

    private static TreeNode getSymmetricTree() {
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

    private static TreeNode getFullBinaryTree() {
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

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }

        public String toString() {
            return String.valueOf(val);
        }

    }

}
