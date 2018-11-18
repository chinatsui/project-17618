package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {


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
            traverse(node.right, history);
            history.add(node.val);
        }
    }

    public enum Solution2 {
        INSTANCE;

        public List<Integer> traverse(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (!stack.empty() && stack.peek().left == node) {
                    TreeNode cur = stack.peek().right;
                    while (cur != null) {
                        stack.push(cur);
                        if (cur.left != null) {
                            cur = cur.left;
                        } else {
                            cur = cur.right;
                        }
                    }
                }
            }
            return res;
        }
    }
}
