package me.chinatsui.algorithm.exercise.dp;


public class ClimbStairs {


    /*
                      n=1, 1
        climb(n) =    n=2, 2
                      n>2, climb(n-1) + climb(n-2)
     */

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(44));
    }

    public int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int way_n_1 = 1;
        int way_n_2 = 2;
        int ways = 0;

        for (int i = 3; i <= n; i++) {
            ways = way_n_1 + way_n_2;
            way_n_1 = way_n_2;
            way_n_2 = ways;
        }

        return ways;
    }

//    public int climbStairs(int n) {
//        return climb(n, new HashMap<>());
//    }
//
//    private int climb(int n, HashMap<Integer, Integer> cache) {
//
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
//
//        if (n == 1) {
//            return 1;
//        }
//
//        if (n == 2) {
//            return 2;
//        }
//
//        int result = climb(n - 1, cache) + climb(n - 2, cache);
//        cache.put(n, result);
//        return result;
//    }

}
