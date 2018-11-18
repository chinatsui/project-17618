package me.chinatsui.algorithm.exercise.arr;

public class ReverseWordsII {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.reverseWords("Let's take LeetCode contest"));
    }

    public enum Solution {
        INSTANCE;

        public String reverseWords(String s) {
            if (s == null) {
                return null;
            }

            s = s.trim();
            char[] ch = s.toCharArray();
            int n = ch.length;
            int src = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == ' ') {
                    reverse(ch, src, i - 1);
                    src = i + 1;
                }
            }
            reverse(ch, src, n - 1);
            return new String(ch);
        }

        private void reverse(char[] ch, int src, int dst) {
            while (src < dst) {
                char tmp = ch[src];
                ch[src] = ch[dst];
                ch[dst] = tmp;
                src++;
                dst--;
            }
        }
    }

}
