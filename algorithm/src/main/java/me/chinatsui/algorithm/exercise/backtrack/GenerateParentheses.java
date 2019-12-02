package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        backtrack(n, n, "", res);
        return res;
    }

    private void backtrack(int left, int right, String cur, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
        } else {
            if (left > 0) {
                backtrack(left - 1, right, cur + "(", res);
            }

            if (left < right) {
                backtrack(left, right - 1, cur + ")", res);
            }
        }
    }
}
