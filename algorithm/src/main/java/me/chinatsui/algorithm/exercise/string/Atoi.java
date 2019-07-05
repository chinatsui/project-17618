package me.chinatsui.algorithm.exercise.string;

public class Atoi {

    public static void main(String[] args) {
        System.out.println(Solution.INSTANCE.convert("+100000"));
    }

    public enum Solution {
        INSTANCE;

        public int convert(String str) {
            if (str == null) {
                return 0;
            }

            int result = 0;
            boolean isPos = true;

            str = str.trim();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (i == 0 && (c == '+' || c == '-')) {
                    isPos = c == '+' ? true : false;
                } else if (c >= '0' && c <= '9') {
                    if (isOverFlow(result, c)) {
                        return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                    result *= 10;
                    result += c - '0';
                } else {
                    return isPos ? result : -result;
                }

            }

            return result;
        }

        private boolean isOverFlow(int result, char c) {
            if (Integer.MAX_VALUE / 10 == result && c - '0' > 7) {
                return true;
            } else if (Integer.MAX_VALUE / 10 < result) {
                return true;
            } else {
                return false;
            }
        }
    }
}
