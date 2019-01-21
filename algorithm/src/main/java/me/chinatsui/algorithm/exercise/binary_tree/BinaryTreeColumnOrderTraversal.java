package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.BinaryTree;
import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeColumnOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinarySearchTree();
        List<List<Integer>> res = Solution.INSTANCE.traverse(root);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> traverse(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            TreeMap<Integer, List<Integer>> history = new TreeMap<>();
            traverse(root, 0, history);
            history.forEach(((k, v) -> {
                res.add(v);
            }));
            return res;
        }

        private void traverse(TreeNode node, int x, TreeMap<Integer, List<Integer>> history) {
            if (node != null) {
                history.putIfAbsent(x, new ArrayList<>());
                history.get(x).add(node.val);
                traverse(node.left, x - 1, history);
                traverse(node.right, x + 1, history);
            }
        }
    }
}