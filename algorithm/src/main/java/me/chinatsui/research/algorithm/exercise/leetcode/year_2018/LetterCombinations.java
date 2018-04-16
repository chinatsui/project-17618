package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.List;

public enum LetterCombinations {

    INSTANCE;

    private static final char[][] words = new char[10][10];

    static {
        words[0] = new char[]{};
        words[1] = new char[]{};
        words[2] = new char[]{'a', 'b', 'c'};
        words[3] = new char[]{'d', 'e', 'f'};
        words[4] = new char[]{'g', 'h', 'i'};
        words[5] = new char[]{'j', 'k', 'l'};
        words[6] = new char[]{'m', 'n', 'o'};
        words[7] = new char[]{'p', 'q', 'r', 's'};
        words[8] = new char[]{'t', 'u', 'v'};
        words[9] = new char[]{'w', 'x', 'y', 'z'};
    }

    public static void main(String[] args) {
        System.out.println(INSTANCE.letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }

        List<String> results = new ArrayList();

        char[] ch = digits.toCharArray();

        for (char c : ch) {
            if ('2' <= c && c <= '9') {
                char[] letters = words[toInt(c)];

                if (results.isEmpty()) {
                    for (char l : letters) {
                        results.add("" + l);
                    }
                } else {
                    List<String> tmp = new ArrayList();
                    for (String prefix : results) {
                        for (char l : letters) {
                            tmp.add(prefix + l);
                        }
                    }
                    results.clear();
                    results.addAll(tmp);
                }
            }
        }
        return results;
    }

    private int toInt(char c) {
        return c - '0';
    }

}
