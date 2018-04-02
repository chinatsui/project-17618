package me.chinatsui.exercise.leetcode.mar;

public enum Atoi {

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
                result += toInteger(c);
            } else {
                return isPos ? result : -result;
            }

        }

        return result;
    }

    private boolean isOverFlow(int result, char c) {
        return result > (result - toInteger(c)) / 10;
    }

    private int toInteger(char c) {
        return c - '0';
    }

}
