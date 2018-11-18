package me.chinatsui.algorithm.exercise.partition;

import java.util.Arrays;

public class FindMedium {

    public static void main(String[] args) {
        int[] data = {24, 1, 2, 3, 56, 43, 23, 24, 278, 32, 11, 15, 18};
        System.out.println(Solution.INSTANCE.find(data));
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
    }

    public enum Solution {
        INSTANCE;

        public int find(int[] nums) {
            int n = nums.length;
            int l = 0;
            int h = n - 1;
            int m = h / 2;

            int p = -1;
            while (p != m) {
                p = partition(nums, l, h);
                if (p < m) {
                    l = p + 1;
                } else if (p > m) {
                    h = p - 1;
                }
            }

            if (n % 2 == 1) {
                return nums[m];
            } else {
                return (nums[m] + nums[m + 1]) / 2;
            }
        }

        private int partition(int[] nums, int l, int h) {
            int pivot = h;
            int sm = l - 1;

            for (int i = l; i < h; i++) {
                if (nums[i] < nums[pivot]) {
                    sm++;
                    if (sm != i) {
                        exchange(nums, sm, i);
                    }
                }
            }
            pivot = sm + 1;
            exchange(nums, pivot, h);
            return pivot;
        }

        private void exchange(int[] nums, int src, int dst) {
            int tmp = nums[dst];
            nums[dst] = nums[src];
            nums[src] = tmp;
        }
    }
}
