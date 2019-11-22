package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 17 - Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * A mapping of digit to mapping (just like on the telephone buttons) is given below.
 *
 * 1: *_*    2:abc   3:def
 * 4: ghi    5:jkl   6:mno
 * 7: pqrs   8:tuv   9:wxyz
 *
 * Note that 1 does not map to any mapping.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {

    private static final char[][] mapping = new char[10][10];

    static {
        mapping[0] = new char[]{};
        mapping[1] = new char[]{};
        mapping[2] = new char[]{'a', 'b', 'c'};
        mapping[3] = new char[]{'d', 'e', 'f'};
        mapping[4] = new char[]{'g', 'h', 'i'};
        mapping[5] = new char[]{'j', 'k', 'l'};
        mapping[6] = new char[]{'m', 'n', 'o'};
        mapping[7] = new char[]{'p', 'q', 'r', 's'};
        mapping[8] = new char[]{'t', 'u', 'v'};
        mapping[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.offer("");
        char[] digitChars = digits.toCharArray();
        for (int i = 0; i < digitChars.length; i++) {
            char[] letters = mapping[digitChars[i] - '0'];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                for (char ch : letters) {
                    queue.offer(cur + ch);
                }
            }
        }

        return queue;
    }
}
