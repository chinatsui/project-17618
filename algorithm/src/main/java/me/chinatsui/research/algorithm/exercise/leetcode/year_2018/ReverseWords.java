package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public class ReverseWords {

    public static void main(String[] args) {
        String res = Solution.INSTANCE.reverseWords("  ");
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;
        public String reverseWords(String s) {
            s = s.trim();
            String[] splits = s.split(" +");
            StringBuilder res = new StringBuilder();
            for (int i = splits.length - 1; i > 0; i--) {
                res.append(splits[i] + " ");
            }
            res.append(splits[0]);
            return res.toString();
        }
    }
}
