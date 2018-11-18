package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        System.out.println(Solution1.INSTANCE.traverse(BinaryTree.getBinarySearchTree()));
        System.out.println(Solution2.INSTANCE.traverse(BinaryTree.getBinarySearchTree()));
    }

    public enum Solution1 {
        INSTANCE;

        public List<Integer> traverse(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            traverse(root, res);
            return res;
        }

        private void traverse(TreeNode node, List<Integer> history) {
            if (node == null) {
                return;
            }
            traverse(node.left, history);
            history.add(node.val);
            traverse(node.right, history);
        }
    }

    public enum Solution2 {
        INSTANCE;

        public List<Integer> traverse(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                res.add(node.val);

                TreeNode cur = node.right;
                while (cur != null) {
                    stack.add(cur);
                    cur = cur.left;
                }
            }
            return res;
        }
    }
}
