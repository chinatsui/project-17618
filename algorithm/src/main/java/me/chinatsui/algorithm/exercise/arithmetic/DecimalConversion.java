package me.chinatsui.algorithm.exercise.arithmetic;

public class DecimalConversion {

    private static final String digits = "0123456789ABCDEF";

    public String convert(int num, int base) {
        doParamsCheck(num, base);

        if (num < base) {
            return strAt(num);
        }

        return convert(num / base, base) + strAt(num % base);
    }

    private void doParamsCheck(int num, int base) {
        if (num < 0 || base < 1 || base > 16) {
            throw new UnsupportedOperationException();
        }
    }

    private String strAt(int pos) {
        return digits.substring(pos, pos + 1);
    }
}
