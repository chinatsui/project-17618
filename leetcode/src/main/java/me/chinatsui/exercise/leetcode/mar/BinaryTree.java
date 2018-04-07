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
        INSTANCE.traverseByLevelOrder(TreeNode.getFullBinaryTree());
        INSTANCE.traverseByColumnOrder(TreeNode.getFullBinaryTree());
        System.out.println(INSTANCE.isSymmetric(TreeNode.getSymmetricTree()));
        System.out.println(INSTANCE.isBinarySearchTree(TreeNode.getBinarySearchTree()));
    }

    public boolean isBinarySearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> history = new ArrayList<>();
        traverseByInOrder(root, history);

        int prev = history.get(0).val;
        for (int i = 1; i < history.size(); i++) {
            int cur = history.get(i).val;
            if (prev >= cur) {
                return false;
            }
            prev = cur;
        }

        return true;
    }

    private void traverseByInOrder(TreeNode node, List<TreeNode> history) {
        if (node != null) {
            traverseByInOrder(node.left, history);
            history.add(node);
            traverseByInOrder(node.right, history);
        }
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

        System.out.println("Level Order: " + Arrays.toString(traverseHistory.toArray()));
    }

    public void traverseByColumnOrder(TreeNode root) {
        TreeMap<Integer, List<TreeNode>> traverseHistory = new TreeMap();
        traverseByColumnOrder(root, 0, traverseHistory);

        System.out.print("Column Order: [");
        for (Map.Entry<Integer, List<TreeNode>> entry : traverseHistory.entrySet()) {
            for (TreeNode node : entry.getValue()) {
                System.out.print(node.val + ", ");
            }
        }
        System.out.println("]");
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

}
