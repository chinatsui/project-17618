package me.chinatsui.algorithm.exercise.binarytree;

/**
 * LeetCode-117
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
 *
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *    \    \
 *     5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *    \    \
 *     5 -> 7 -> NULL
 */
public class PopulateNextPointersII extends PopulateNextPointers {

    public void populate(Node root) {
        while (root != null) {
            Node row = root, child = null;

            // connect next pointers for current level.
            while (row != null) {
                if (row.left != null) {
                    child = row.left;
                    if (row.right != null) {
                        child.next = row.right;
                        child = child.next;
                    }
                } else if (row.right != null){
                    child = row.right;
                }

                if (row.next != null) {
                    if (child != null) {
                        if (row.next.left != null) {
                            child.next = row.next.left;
                        } else if (row.next.right != null) {
                            child.next = row.next.right;
                        }
                    }
                }

                row = row.next;
            }

            // find the head node for next level.
            Node nextRoot = null;
            while (nextRoot == null) {
                if (root.left != null) {
                    nextRoot = root.left;
                } else {
                    nextRoot = root.right;
                }

                if (root.next == null) {
                    break;
                } else {
                    root = root.next;
                }
            }
            root = nextRoot;
        }
    }
}
