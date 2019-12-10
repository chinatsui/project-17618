package me.chinatsui.algorithm.exercise.string;

public class IsomorphicStrings {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(-1 % 3);

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() < 1) {
            return true;
        }

        int[] m1 = new int[256], m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (m1[ch1] != m2[ch2]) {
                return false;
            }

            m1[ch1] = m2[ch2] = i + 1;
        }

        return true;
    }
}
