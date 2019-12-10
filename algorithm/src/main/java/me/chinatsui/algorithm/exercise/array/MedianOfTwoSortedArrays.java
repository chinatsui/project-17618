package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode-4
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double resolve(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return resolve(nums2, nums1);
        }

        // select i elements from nums1 and j elements from nums2 to first half.
        int i = 0, j = 0;

        /*
         * iLo refers to minimum count of elements we can select from nums1,
         * iHi refers to maximum count of elements we can select from nums1.
         * So use iLo and iHi to find the target i to select elements from nums1.
         */
        double maxLeft = Double.NaN;
        int iLo = 0, iHi = n;
        while (iLo <= iHi) {
            i = iLo + ((iHi + 1 - iLo) >> 1);
            j = n + (m + 1 - n) / 2 - i;
            if (j > 0 && i < n && nums2[j - 1] > nums1[i]) {
                // should select more elements from nums1, "i" should be bigger
                iLo = i + 1;
            } else if (i > 0 && j < m && nums1[i - 1] > nums2[j]) {
                // should select more elements from nums2, "i" should be smaller
                iHi = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }

        if ((n + m) % 2 == 1) {
            return maxLeft;
        }

        double minRight;
        if (i == n) {
            minRight = nums2[j];
        } else if (j == m) {
            minRight = nums1[i];
        } else {
            minRight = Math.min(nums1[i], nums2[j]);
        }

        return (maxLeft + minRight) / 2;
    }
}
