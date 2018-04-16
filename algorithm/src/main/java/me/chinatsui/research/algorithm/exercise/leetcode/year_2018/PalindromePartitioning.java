package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.ArrayList;
import java.util.List;

public enum PalindromePartitioning {

    INSTANCE;

    public static void main(String[] args) {
        List<List<String>> res = INSTANCE.partition("aabb");
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        track(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void track(String s, int start,
                       List<String> cur, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    cur.add(s.substring(start, i + 1));
                    track(s, i + 1, cur, res);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int l, int h) {
        while(l < h)
            if (s.charAt(l++) != s.charAt(h--)) return false;
        return true;
    }

}
