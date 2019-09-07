package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {


    public static void main(String[] args) {
        System.out.println(Solution1.INSTANCE.traverse(TreeNodes.getBinarySearchTree()));
        System.out.println(Solution2.INSTANCE.traverse(TreeNodes.getBinarySearchTree()));
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
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            pushNodes(stack, root);

            while (!stack.empty()) {
                TreeNode node = stack.pop();
                res.add(node.val);
                if (!stack.empty() && stack.peek().left == node) {
                    TreeNode cur = stack.peek().right;
                    pushNodes(stack, cur);
                }
            }
            return res;
        }

        private void pushNodes(Stack<TreeNode> stack, TreeNode node) {
            while (node != null) {
                stack.push(node);
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
    }
}
