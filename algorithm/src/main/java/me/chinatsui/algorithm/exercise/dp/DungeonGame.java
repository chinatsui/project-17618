package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode 174. Dungeon Game
 * <p>
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned
 * in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer.
 * If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible,
 * the knight decides to move only rightward or downward in each step.
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal
 * path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	      3
 * -5	    -10	      1
 * 10	     30	     -5 (P)
 * <p>
 * Note:
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room
 * where the princess is imprisoned.
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }

        int n = dungeon.length, m = dungeon[0].length;
        int[][] health = new int[n][m];

        health[n - 1][m - 1] = Math.max(1 - dungeon[n - 1][m - 1], 1);

        for (int i = n - 2; i >= 0; i--) {
            health[i][m - 1] = Math.max(health[i + 1][m - 1] - dungeon[i][m - 1], 1);
        }

        for (int j = m - 2; j >= 0; j--) {
            health[n - 1][j] = Math.max(health[n - 1][j + 1] - dungeon[n - 1][j], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }
}
