package me.chinatsui.algorithm.exercise.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

    public static void main(String[] args) {
        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        int[] nums = {1, 5, 9, 1, 5, 9};
        System.out.println(cd.containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }

        int groupSize = t + 1;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                int oldNum = nums[i - k - 1];
                int oldGroup = oldNum / groupSize;
                if (oldNum < 0) {
                    oldGroup--;
                }
                cache.remove(oldGroup);
            }

            int num = nums[i];
            int group = num / groupSize;

            if (num < 0) {
                group--;
            }

            if (cache.containsKey(group)) {
                return true;
            }

            if (cache.containsKey(group - 1) && Math.abs(cache.get(group - 1) - num) < groupSize) {
                return true;
            }

            if (cache.containsKey(group + 1) && Math.abs(cache.get(group + 1) - num) < groupSize) {
                return true;
            }

            cache.put(group, num);
        }

        return false;
    }
}
