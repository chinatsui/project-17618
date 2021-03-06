package me.chinatsui.algorithm.exercise.binarytree;

/**
 * LeetCode-116
 *
 * Given a binary tree
 *
 * TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (all leaves are at the same level, and every parent has two children).
 *
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 *
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulateNextPointers {

    public void populate(Node root) {
        while (root != null) {
            Node row = root;
            while (row != null) {
                if (row.left != null) {
                    row.left.next = row.right;
                    if (row.next != null) {
                        row.right.next = row.next.left;
                    }
                }
                row = row.next;
            }
            root = root.left;
        }
    }

    protected static class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
