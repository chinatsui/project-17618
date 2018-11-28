package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.BinaryTree;
import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        System.out.println(Solution1.INSTANCE.traverse(BinaryTree.getBinarySearchTree()));
        System.out.println(Solution2.INSTANCE.traverse(BinaryTree.getBinarySearchTree()));
    }

    public enum Solution1 {
        INSTANCE;

        public List<Integer> traverse(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                traverse(root, res);
            }
            return res;
        }

        private void traverse(TreeNode node, List<Integer> history) {
            history.add(node.val);

            if (node.left != null) {
                traverse(node.left, history);
            }

            if (node.right != null) {
                traverse(node.right, history);
            }
        }
    }

    public enum Solution2 {
        INSTANCE;

        public List<Integer> traverse(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                res.add(node.val);

                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }

            return res;
        }
    }
}
