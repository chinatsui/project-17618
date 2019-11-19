package me.chinatsui.algorithm.exercise.binarysearch;

import java.util.Arrays;

/**
 * USACO 2018 December Contest, Silver
 * Problem 1. Convention
 * <p>
 * Farmer John is hosting a new bovine grass-eating convention at his farm! Cows from all over the world are arriving
 * at the local airport to attend the convention and eat grass.
 * <p>
 * Specifically, there are N cows arriving at the airport (1 <= N <= 10^5) and cow i arrives at time t[i] (0 <= t[i] <= 10^9).
 * Farmer John has arranged M (1 <= M <= 10^5) buses to transport the cows from the airport. Each bus can hold up C cows in int (1 <= C <= N).
 * Farmer John is waiting with the buses at the airport and would like to assign the cows to the buses. A bus can leave at the time when
 * the last cow on it arrives.
 * <p>
 * Farmer John wants to be a good host and so does not want to keep arriving cows waiting at the airport too long.
 * What is the smallest possible value of the maximum waiting time for any one arriving cow if Farmer John coordinates his buses optimally?
 * A cow's waiting time is the difference between her arrival time and the departure of her assigned bus.
 * <p>
 * It is guaranteed that M*C >= N.
 * <p>
 * INPUT FORMAT:
 * The first line contains three space separated integers N, M and C. The next line contains N space separated integers
 * representing the arrival time of each cow.
 * <p>
 * OUTPUT FORMAT:
 * Please write one line containing the optimal minimum maximum waiting time for any cow arriving now.
 * <p>
 * SAMPLE INPUT:
 * <p>
 * 6 3 2
 * 1 1 10 14 4 3
 * <p>
 * <p>
 * SAMPLE OUTPUT:
 * <p>
 * 4
 * <p>
 * EXPLANATION:
 * <p>
 * If the two cows arriving at 1 go in bus #1, cows arriving at 3 and 4 go in bus #2, and cows arriving at 10 and 14 go
 * in bus #3, the longest time a cow has to wait is 4 time units (the cow arriving at 10 waits until 14).
 */
public class TransportCows {

    private final int N, M, C;
    private final int[] time;

    public TransportCows(int n, int m, int c, int[] time) {
        this.N = n;
        this.M = m;
        this.C = c;
        this.time = time;
    }

    /**
     * Note that the corresponding "decision problem"--determine whether M buses suffice
     * if every cow waits at most T minutes--can be solved efficiently by a greedy algorithm.
     * <p>
     * Additionally, the decision problem is monotonic in T: that is, if a maximum waiting time of T is impossible,
     * then no smaller maximum waiting time will be possible.
     */
    public int resolve() {
        Arrays.sort(time);
        int lo = 0, hi = time[N - 1] - time[0];
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (suffice(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }

        return suffice(lo) ? lo : hi;
    }

    private boolean suffice(int waitTime) {
        int buses = 1;
        int firstArrival = time[0], index = 0;
        for (int i = 1; i < N; i++) {
            // arrange to next bus
            if (time[i] - firstArrival > waitTime || i - index + 1 > C) {
                buses++;
                firstArrival = time[i];
                index = i;
            }
        }

        return buses <= M;
    }
}
