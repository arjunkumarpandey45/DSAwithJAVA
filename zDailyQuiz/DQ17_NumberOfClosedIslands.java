package zDailyQuiz;



public class DQ17_NumberOfClosedIslands {

    public static void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;

        vis[i][j] = true;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        for (int l = 0; l < 4; l++) {
            int delRow = i + row[l];
            int delCol = j + col[l];

            if (delRow >= 0 && delRow < m &&
                delCol >= 0 && delCol < n &&
                grid[delRow][delCol] == 0 &&
                !vis[delRow][delCol]) {

                vis[delRow][delCol] = true;
                dfs(delRow, delCol, grid, vis);
            }
        }
    }

    public static int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0 && !vis[i][0]) {
                dfs(i, 0, grid, vis);
            }
        }

        
        for (int i = 0; i < m; i++) {
            if (grid[i][n - 1] == 0 && !vis[i][n - 1]) {
                dfs(i, n - 1, grid, vis);
            }
        }

       
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0 && !vis[0][j]) {
                dfs(0, j, grid, vis);
            }
        }

        
        for (int j = 0; j < n; j++) {
            if (grid[m - 1][j] == 0 && !vis[m - 1][j]) {
                dfs(m - 1, j, grid, vis);
            }
        }

        int count = 0;

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println("Number of Closed Islands: " + closedIsland(grid));
    }
}
