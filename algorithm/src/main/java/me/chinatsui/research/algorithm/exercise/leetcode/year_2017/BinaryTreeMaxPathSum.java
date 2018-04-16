package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

/**
 * Created by chinatsui on 14/01/2018.
 */
public class BinaryTreeMaxPathSum {

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;

        System.out.println(new BinaryTreeMaxPathSum().maxPathSum(t0));
    }

    private int noParent = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int rootSum = root.val + traverse(root.left) + traverse(root.right);
        return Math.max(noParent, rootSum);
    }

    public int traverse(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int left = root.left != null ? traverse(root.left) : 0;

        int right = root.right != null ? traverse(root.right) : 0;

        // When link to parent, only select "root + left" / "root + right" / "root".
        int rootSum = Math.max(Math.max(left + root.val, right + root.val), root.val);

        // When not link to parent, then select "root + left + right" / "link to parent"
        int localNoParent = Math.max(rootSum, left + right + root.val);

        //用当前最大来更新全局最大
        noParent = Math.max(localNoParent, noParent);
        return rootSum;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
