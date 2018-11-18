package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public enum BinaryTreeLevelOrderTraversal {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.traverse(BinaryTree.getSymmetricTree()));
    }

    public List<Integer> traverse(TreeNode root) {
        List<Integer> history = new ArrayList();

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            history.add(node.val);

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return history;
    }


}
