package me.chinatsui.algorithm.exercise.array;

public class AlmostOrdered {

    public static void main(String[] args) {
        AlmostOrdered almostOrdered = new AlmostOrdered();
        System.out.println(almostOrdered.isAlmostOrdered(new int[]{1, 2, 3, 6, 5, 12}));
        System.out.println(almostOrdered.isAlmostOrdered(new int[]{1, 5, 4, 3, 6}));
        System.out.println(almostOrdered.isAlmostOrdered(new int[]{3, 2, 1, 0}));
    }

    public boolean isAlmostOrdered(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int n = nums.length;
        int peak = -1, valley = -1;

        for (int i = 0; i < n - 1; i++) {
            if (peak == -1 && nums[i] > nums[i + 1]) {
                peak = i;
            } else if (peak != -1 && valley == -1 && nums[i] < nums[i + 1] && nums[i] < nums[i - 1]) {
                valley = i;
            }
        }

        if (peak == -1) {
            return true;
        } else if (valley == -1) {
            return false;
        }

        return check(nums, 0, peak - 1) && check(nums, peak + 1, valley - 1) && check(nums, valley + 1, n - 1);
    }

    private boolean check(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }

        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
