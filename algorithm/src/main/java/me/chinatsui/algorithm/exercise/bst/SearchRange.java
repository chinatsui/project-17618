package me.chinatsui.algorithm.exercise.bst;

import java.util.ArrayList;
import java.util.List;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LintCode-11
 *
 * Given a binary search tree and a range [k1, k2], return node values within a given range in ascending order.
 *
 * Example 1:
 *
 * Input：{5},6,10
 * Output：[]
 *         5
 * it will be serialized {5}
 * No number between 6 and 10
 *
 * Example 2:
 *
 * Input：{20,8,22,4,12},10,22
 * Output：[12,20,22]
 * Explanation：
 *         20
 *        /  \
 *       8   22
 *      / \
 *     4   12
 * it will be serialized {20,8,22,4,12}
 * [12,20,22] between 10 and 22
 */
public class SearchRange {


    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> res = new ArrayList<>();
        search(root, k1, k2, res);
        return res;
    }

    private void search(TreeNode node, int k1, int k2, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (k1 < node.val) {
            search(node.left, k1, k2, res);
        }

        if (k1 <= node.val && node.val <= k2) {
            res.add(node.val);
        }

        if (node.val < k2) {
            search(node.right, k1, k2, res);
        }
    }
}
