package me.chinatsui.algorithm.exercise.arithmetic;

public class PrimeNumSum {

    public static void main(String[] args) {
        long sum = Solution.INSTANCE.getSum(1, 1000000);
        System.out.println(sum);
    }

    public enum Solution {
        INSTANCE;

        public long getSum(int rangeStart, int rangeEnd) {
            long sum = 0;
            for (int i = rangeStart; i <= rangeEnd; i++) {
                if (isPrime(i)) {
                    sum += i;
                }
            }
            return sum;
        }

        private boolean isPrime(long num) {
            long sqrt = Math.round(Math.sqrt(num));
            for (int i = 2; i < sqrt + 1; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
