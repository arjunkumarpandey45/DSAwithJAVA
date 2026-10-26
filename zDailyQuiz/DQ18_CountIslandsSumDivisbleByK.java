package zDailyQuiz;




public class DQ18_CountIslandsSumDivisbleByK {

    public static void dfs(int i, int j, int[][] grid,
                           boolean[][] vis, long[] sum) {
        int m = grid.length;
        int n = grid[0].length;

        vis[i][j] = true;
        sum[0] += grid[i][j];

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nr = i + row[d];
            int nc = j + col[d];

            if (nr >= 0 && nr < m &&
                nc >= 0 && nc < n &&
                grid[nr][nc] != 0 &&
                !vis[nr][nc]) {

                dfs(nr, nc, grid, vis, sum);
            }
        }
    }

    public static int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0 && !vis[i][j]) {
                    long[] sum = new long[1];

                    dfs(i, j, grid, vis, sum);

                    if (sum[0] % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1000000, 1000000, 1000000},
            {1000000, 1000000, 1000000},
            {0, 0, 1000000}
        };

        int k = 3;

        System.out.println(countIslands(grid, k));
    }
}
