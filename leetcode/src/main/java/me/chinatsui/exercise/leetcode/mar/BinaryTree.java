package me.chinatsui.exercise.leetcode.mar;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    public static void main(String[] args) {
        Integer[] levelOrder = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode root = deserializeFromLevelOrder(levelOrder);

        System.out.println(root);
    }

    public static TreeNode deserializeFromPreorder(Integer[] preorder) {
        LinkedList<Integer> list = new LinkedList();
        list.addAll(Arrays.asList(preorder));
        return buildTreeFromPreorder(list);
    }

    private static TreeNode buildTreeFromPreorder(LinkedList<Integer> linkedList) {
        Integer val = linkedList.poll();
        if (val == null) {
            return null;
        } else {
            TreeNode root = new TreeNode(val);
            root.left = buildTreeFromPreorder(linkedList);
            root.right = buildTreeFromPreorder(linkedList);
            return root;
        }
    }

    public static TreeNode deserializeFromLevelOrder(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length < 1) {
            return null;
        }

        LinkedList<Integer> history = new LinkedList<>();
        history.addAll(Arrays.asList(levelOrder));

        TreeNode root;
        Integer rootVal = history.poll();
        if (rootVal == null) {
            root = null;
        } else {
            root = new TreeNode(rootVal);
        }

        LinkedList<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            Integer val = history.poll();
            if (val != null) {
                TreeNode left = new TreeNode(val);
                node.left = left;
                q.offer(left);
            }

            val = history.poll();
            if (val != null) {
                TreeNode right = new TreeNode(val);
                node.right = right;
                q.offer(right);
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
