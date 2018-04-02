package me.chinatsui.exercise.leetcode.mar;

public enum WordSearch {

    INSTANCE;

    private boolean found;
    private boolean[][] visited;

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean isExist = INSTANCE.exist(board, word);
        System.out.println(isExist);
    }

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }

            for (int j = 0; j < n; j++) {
                if (found) {
                    break;
                }
                dfs(board, i, j, "", word);
            }
        }

        return found;
    }

    private void dfs(char[][] board, int m, int n, String cur, String word) {
        if (found) {
            return;
        }

        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length) {
            return;
        }

        if (visited[m][n]) {
            return;
        }

        cur += board[m][n];

        if (!word.startsWith(cur)) {
            return;
        }

        if (word.equals(cur)) {
            found = true;
            return;
        }

        visited[m][n] = true;
        dfs(board, m, n - 1, cur, word);
        dfs(board, m, n + 1, cur, word);
        dfs(board, m - 1, n, cur, word);
        dfs(board, m + 1, n, cur, word);
        visited[m][n] = false;
    }

}
