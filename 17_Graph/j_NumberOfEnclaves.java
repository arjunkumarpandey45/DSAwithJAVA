

public class j_NumberOfEnclaves {

    static void dfs(int row, int col, int[][] grid,
                    int[] delRow, int[] delCol) {

        int m = grid.length;
        int n = grid[0].length;

        
        grid[row][col] = 0;

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, grid, delRow, delCol);
            }
        }
    }

    static int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

      
        for (int i = 0; i < n; i++) {

            if (grid[0][i] == 1) {
                dfs(0, i, grid, delRow, delCol);
            }

            if (grid[m - 1][i] == 1) {
                dfs(m - 1, i, grid, delRow, delCol);
            }
        }

       
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 1) {
                dfs(i, 0, grid, delRow, delCol);
            }

            if (grid[i][n - 1] == 1) {
                dfs(i, n - 1, grid, delRow, delCol);
            }
        }

        
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        int ans = numEnclaves(grid);

        System.out.println("Number of Enclaves: " + ans);
    }
}