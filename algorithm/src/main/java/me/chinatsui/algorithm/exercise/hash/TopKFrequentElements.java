package me.chinatsui.algorithm.exercise.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * No.347
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4};
        List<Integer> result = new TopKFrequentElements().topKFrequent2(nums, 2);
        System.out.println(result);
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // o(n)
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // o(n)
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        // o(k)
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (res.size() == k) {
                break;
            }

            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }

    /*
     * My first solution.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        //o(n)
        for (int num : nums) {

            if (numCountMap.containsKey(num)) {
                int count = numCountMap.get(num);
                count++;
                numCountMap.put(num, count);
            } else {
                numCountMap.put(num, 1);
            }
        }

        // o(n)
        List<Entry> entryList = new ArrayList<>();
        for (int key : numCountMap.keySet()) {
            int count = numCountMap.get(key);
            Entry entry = new Entry(count, key);
            entryList.add(entry);
        }

        // o(n*logn)
        entryList.sort((Entry o1, Entry o2) -> o2.getCount() - o1.getCount());

        // o(n)
        Iterator<Entry> itr = entryList.iterator();
        Integer[] result = new Integer[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = itr.next().getNum();
        }

        return Arrays.asList(result);
    }

    private static class Entry {
        private int count;
        private int num;

        public Entry(int count, int num) {
            this.count = count;
            this.num = num;
        }

        public int getCount() {
            return count;
        }

        public int getNum() {
            return num;
        }
    }

}
