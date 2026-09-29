package zDailyQuiz;

import java.util.*;

public class DQ3_CheckValidParenthesesPath {

    public static boolean bfs(char[][] grid, boolean[][][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        int[] right = {0, 1};
        int[] down = {1, 0};

        if (grid[0][0] == ')') {
            return false;
        }

        vis[0][0][1] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            int balance = current[2];

            if (row == m - 1 &&
                col == n - 1 &&
                balance == 0) {

                return true;
            }

            for (int i = 0; i < 2; i++) {

                int nr = row + right[i];
                int nc = col + down[i];

                int newBalance = balance;

                if (nr >= m || nc >= n) {
                    continue;
                }

                if (grid[nr][nc] == '(') {
                    newBalance++;
                } else {
                    newBalance--;
                }

                if (newBalance < 0) {
                    continue;
                }

                if (!vis[nr][nc][newBalance]) {

                    vis[nr][nc][newBalance] = true;

                    q.add(new int[]{
                        nr,
                        nc,
                        newBalance
                    });
                }
            }
        }

        return false;
    }

    public static boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][][] vis =
                new boolean[m][n][m + n];

        return bfs(grid, vis);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'(', '(', ')'},
                {'(', ')', ')'}
        };

        boolean result = hasValidPath(grid);

        System.out.println("Has Valid Path: " + result);
    }
}
