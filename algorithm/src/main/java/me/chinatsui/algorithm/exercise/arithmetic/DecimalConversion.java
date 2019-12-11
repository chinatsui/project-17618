package me.chinatsui.algorithm.exercise.arithmetic;

public class DecimalConversion {

    private static final char[] digits = "0123456789ABCDEF".toCharArray();

    public String convert(int num, int base) {
        doParamsCheck(num, base);

        if (num < base) {
            return digits[num] + "";
        }

        return convert(num / base, base) + digits[num % base];
    }

    private void doParamsCheck(int num, int base) {
        if (num < 0 || base < 1 || base > 16) {
            throw new UnsupportedOperationException();
        }
    }
}
