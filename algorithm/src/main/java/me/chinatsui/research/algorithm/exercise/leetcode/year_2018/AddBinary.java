package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum AddBinary {

    INSTANCE;

    public static void main(String[] args) {
        String result = INSTANCE.addBinary("1010", "1011");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        char[] longer = (a.length() < b.length() ? b : a).toCharArray();
        char[] shorter = (a.length() < b.length() ? a : b).toCharArray();

        int diff = longer.length - shorter.length;

        int idx = longer.length - 1;
        int carry = 0;
        while (idx >= 0) {
            char longCh = longer[idx];
            int n = 0;
            if (idx - diff >= 0) {
                char shortCh = shorter[idx - diff];
                n = toInt(longCh) + toInt(shortCh) + carry;
            } else {
                n = toInt(longCh) + carry;
            }
            carry = n / 2;
            n = n % 2;
            longer[idx] = toChar(n);
            idx--;
        }

        StringBuilder result = new StringBuilder(new String(longer));
        if (carry > 0) {
            result.insert(0, '1');
        }
        return result.toString();
    }

    private int toInt(char ch) {
        return ch == '1' ? 1 : 0;
    }

    private char toChar(int num) {
        return num == 1 ? '1' : '0';
    }

}
