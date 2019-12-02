package me.chinatsui.algorithm.exercise.trick;

/**
 * Given an integer, find the most occurring digit in it.
 * If two or more digits occur same number of times, then return the highest of them.
 * Input integer is given as an int variable, not as a string or array.
 * Use of hash or array or string is not allowed.
 * <p>
 * Example:
 * <p>
 * Input:  x = 12234
 * Output: The most frequent digit is 2
 * <p>
 * Input:  x = 1223377
 * Output: The most frequent digit is 7
 * <p>
 * Input:  x = 5
 * Output: The most frequent digit is 5
 * <p>
 * Input:  x = 1000
 * Output: The most frequent digit is 0
 */
public class MostFrequentDigit {

    public static void main(String[] args) {
        MostFrequentDigit mfd = new MostFrequentDigit();
        System.out.println(mfd.resolve(12234));
        System.out.println(mfd.resolve(1223377));
        System.out.println(mfd.resolve(5));
        System.out.println(mfd.resolve(1000));
    }

    public int resolve(int num) {
        if (num == 0) {
            return 0;
        }

        if (num < 0) {
            num = -num;
        }

        int res = -1, maxCount = 1;
        for (int i = 0; i <= 9; i++) {
            int count = count(num, i);
            if (count > maxCount) {
                res = i;
                maxCount = count;
            } else if (count == maxCount) {
                res = Math.max(res, i);
            }
        }

        return res;
    }

    private int count(int num, int digit) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == digit) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
