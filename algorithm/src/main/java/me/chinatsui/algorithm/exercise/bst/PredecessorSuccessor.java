package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;

public class PredecessorSuccessor {

    public Result resolve(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            TreeNode predecessor = null, successor = null;
            // find predecessor
            if (root.left != null) {
                TreeNode left = root.left;
                while (left.right != null) {
                    left = left.right;
                }
                predecessor = left;
            }

            // find successor
            if (root.right != null) {
                TreeNode right = root.right;
                while (right.left != null) {
                    right = right.left;
                }
                successor = right;
            }

            return new Result(predecessor, successor);
        } else if (root.val < val) {
            return resolve(root.right, val);
        } else {
            return resolve(root.left, val);
        }
    }

    static class Result {
        private TreeNode predecessor;
        private TreeNode successor;

        public Result(TreeNode predecessor, TreeNode successor) {
            this.predecessor = predecessor;
            this.successor = successor;
        }

        public TreeNode getPredecessor() {
            return predecessor;
        }

        public TreeNode getSuccessor() {
            return successor;
        }
    }
}
