package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 553. Optimal Division
 * <p>
 * Given a list of positive integers, the adjacent integers will perform the float division.
 * For example, [2,3,4] -> 2 / 3 / 4.
 * <p>
 * However, you can add any number of parenthesis at any position to change the priority of operations.
 * You should find out how to add parenthesis to get the maximum result, and return the corresponding expression
 * in string format. Your expression should NOT contain redundant parenthesis.
 * <p>
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 * <p>
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * <p>
 * Note:
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 */
public class OptimalDivision {

    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                sb.append("/");
            }

            /**
             * In order to make the value of "numerator/denominator" largest, we have to make the numerator as large as
             * possible and the denominator as small as possible.
             * For the case of "a/b/c/d/e/f...", interestingly putting "(" in front of the second number and ")"
             * in the back of the last number is just the optimal solution, because "a" is the largest as a numerator
             * and the "rest part" is the smallest, thus the result is the largest.
             */
            if (i == 1 && n > 2) {
                sb.append("(");
            }

            sb.append(nums[i]);

            if (i == n - 1 && n > 2) {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
