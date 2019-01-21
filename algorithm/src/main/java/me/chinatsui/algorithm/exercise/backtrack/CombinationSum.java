package me.chinatsui.algorithm.exercise.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = Solution.INSTANCE.combinationSum(candidates, target);
        System.out.println(res);
    }

    public enum Solution {
        INSTANCE;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> cur = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();

            track(candidates, 0, target, cur, res);

            return res;
        }

        private void track(int[] candidates, int start, int remain,
                           List<Integer> cur, List<List<Integer>> res) {
            if (remain < 0) {
                return;
            } else if (remain == 0) {
                res.add(new ArrayList<>(cur));
            } else {
                for (int i = start; i < candidates.length; i++) {
                    cur.add(candidates[i]);
                    remain = remain - candidates[i];
                    track(candidates, i, remain, cur, res);
                    remain = remain + candidates[i];
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
