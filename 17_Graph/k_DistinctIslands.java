import java.util.*;

public class k_DistinctIslands {

    static void dfs(int row, int col, int[][] grid,
                    int baseRow, int baseCol,
                    ArrayList<String> shape) {

        int m = grid.length;
        int n = grid[0].length;

        grid[row][col] = 0;

        
        shape.add((row - baseRow) + "," + (col - baseCol));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                grid[nrow][ncol] == 1) {

                dfs(nrow, ncol, grid,
                    baseRow, baseCol, shape);
            }
        }
    }

    static int countDistinctIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        HashSet<ArrayList<String>> set = new HashSet<>();

        for (int row = 0; row < m; row++) {

            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) {

                    ArrayList<String> shape = new ArrayList<>();

                    dfs(row, col, grid,
                        row, col, shape);

                    set.add(shape);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0}
        };

        int ans = countDistinctIslands(grid);

        System.out.println("Distinct Islands: " + ans);
    }
}