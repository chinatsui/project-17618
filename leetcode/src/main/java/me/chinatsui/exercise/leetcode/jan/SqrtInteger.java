package me.chinatsui.exercise.leetcode.jan;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by chinatsui on 11/01/2018.
 */
public class SqrtInteger {

    public static void main(String[] args) {
        System.out.println(new SqrtInteger().square(8));
    }

    public BigDecimal square(float n) {
        BigDecimal number = new BigDecimal(n);
        BigDecimal lo = new BigDecimal(0f);
        BigDecimal hi = new BigDecimal(n);
        BigDecimal divisor = new BigDecimal(2);

        while (lo.compareTo(hi) < 0) {
            BigDecimal mid = lo.add(hi).divide(divisor);
            BigDecimal multiply = mid.multiply(mid);
            if (multiply.compareTo(number) < 0) {
                lo = mid.setScale(6, RoundingMode.CEILING);
            } else if (multiply.compareTo(number) > 0) {
                hi = mid.setScale(6, RoundingMode.FLOOR);
            } else {
                return mid.setScale(6);
            }
        }

        return lo;
    }


}
