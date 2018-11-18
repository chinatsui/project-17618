package me.chinatsui.algorithm.exercise.dp;

public enum LongestPalindrome {

    INSTANCE;

    public static void main(String[] args) {
        System.out.println(INSTANCE.longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        // ch[i][j] -> ch[i] + ch[i+1][j-1] + ch[j];

        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return "";
        }

        int n = s.length();

        int[][] state = new int[n][n];
        for (int i = 0; i < n; i++) {
            state[i][i] = 1;
        }

        String result = s.substring(0,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j ++) {
                if (j + 1 <= i - 1) {
                    state[j][i] = s.charAt(j) == s.charAt(i) && state[j+1][i-1] == 1 ? 1 : 0;
                } else {
                    state[j][i] = s.charAt(j) == s.charAt(i) ? 1 : 0;
                }

                if (state[j][i] == 1 && i - j + 1 > result.length()) {
                    result = s.substring(j, i + 1);
                }
            }
        }

        return result;
    }

}
