package me.chinatsui.algorithm.exercise.array;

public class AddBinary {

    public static void main(String[] args) {
        String result = Solution.INSTANCE.addBinary("1010101", "1011");
        System.out.println(result);
    }

    public enum Solution {
        INSTANCE;

        public String addBinary(String a, String b) {
            if (a == null || a.isEmpty()) {
                return b;
            }

            if (b == null || b.isEmpty()) {
                return a;
            }

            StringBuffer res = new StringBuffer();
            int carry = 0;
            int i = a.length() - 1, j = b.length() - 1;
            while (i >= 0 && j >= 0) {
                int sum = 0;
                int a_digit = toInt(a.charAt(i));
                int b_digit = toInt(b.charAt(j));
                sum += a_digit + b_digit + carry;
                carry = sum / 2;
                sum %= 2;
                res.insert(0, toChar(sum));
                i--;
                j--;
            }

            int k = Math.max(i, j);
            while (k >= 0) {
                int sum = 0;
                int digit = toInt(a.charAt(k));
                sum += digit + carry;
                carry = sum / 2;
                sum %= 2;
                res.insert(0, toChar(sum));
                k--;
            }

            if (carry > 0) {
                res.insert(0, toChar(carry));
            }

            return res.toString();
        }

        private int toInt(char ch) {
            return ch == '1' ? 1 : 0;
        }

        private char toChar(int num) {
            return num == 1 ? '1' : '0';
        }
    }
}
