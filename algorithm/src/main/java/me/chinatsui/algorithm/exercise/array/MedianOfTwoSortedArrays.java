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

        int i = 0, j = 0; // select i elements from nums1 and j elements from nums2 to first half.
        int iMin = 0, iMax = n;
        double maxLeft = 0;
        while (iMin <= iMax) {
            i = (iMin + iMax + 1) / 2;
            j = (n + m + 1) / 2 - i;
            if (j > 0 && i < n && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > 0 && j < m && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                if (i == 0) {
                    maxLeft = (double) nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = (double) nums1[i - 1];
                } else {
                    maxLeft = (double) Math.max(nums1[i - 1], nums2[j - 1]);
                }
                break;
            }
        }

        if ((n + m) % 2 == 1) {
            return maxLeft;
        }

        double minRight;
        if (i == n) {
            minRight = (double) nums2[j];
        } else if (j == m) {
            minRight = (double) nums1[i];
        } else {
            minRight = (double) Math.min(nums1[i], nums2[j]);
        }

        return (maxLeft + minRight) / 2;
    }
}
