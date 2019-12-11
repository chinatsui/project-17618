package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 204. Count Primes
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    /**
     * This solution is simply based on Sieve of Eratosthenes.
     * <p>
     * 1. Init an array of n booleans to true
     * 2. Loop through array and set multiples of prime p to false;
     * 3. Loop through array and count the primes
     * <p>
     * Since you know any multiple of 2 can't be a prime, you can eliminate a huge chunk of work from all three steps.
     * Just start at 3 and iterate by 2 through the loops.
     */
    public int countPrimes(int n) {
        //Sieve
        if (n <= 2) {
            return 0;
        }

        boolean[] sieve = new boolean[n];
        sieve[2] = true;
        for (int i = 3; i < n; i += 2) { // Even number won't be prime
            sieve[i] = true;
        }

        for (int i = 3; i * i < n; i += 2) {
            if (sieve[i]) {
                for (int j = i * 2; j < n; j += i) { // Multiples of prime won't be prime
                    sieve[j] = false;
                }
            }
        }

        int count = 1; // stands for 2
        for (int i = 3; i < n; i += 2) { // rest are all prime numbers
            count += sieve[i] ? 1 : 0;
        }

        return count;
    }
}
