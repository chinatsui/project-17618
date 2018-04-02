package me.chinatsui.exercise.leetcode.mar.tree;

public enum LowestCommonAncestorBST {

    INSTANCE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);

        root.left = new TreeNode(8);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(15);

        System.out.println(INSTANCE.lowestCommonAncestor(root, root.left.left, root.left.right.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int val = root.val;
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);

            if (min <= val && val <= max) {
                return root;
            } else if (val < min) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }

}
