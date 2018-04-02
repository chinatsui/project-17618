package me.chinatsui.exercise.leetcode.mar;

public enum RemoveDuplicates {

    INSTANCE;

    public static void main(String[] args) {
        int[] x = {1, 1, 2};
        System.out.println(INSTANCE.removeDuplicates(x));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[prev]) {
                nums[++prev] = nums[i];
            }
        }

        return ++prev;
    }

}
