package DisJoint;


import java.util.*;

public class e_MakingALargeIsland {

    private static int n;

    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int largestIsland(int[][] grid) {
        n = grid.length;

        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2;
        int maxArea = 0;

        // Step 1: Label each island and calculate its area
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }

        // Step 2: Try converting each 0 into 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int area = 1;

                    for (int[] dir : directions) {
                        int nr = i + dir[0];
                        int nc = j + dir[1];

                        if (nr >= 0 && nr < n &&
                            nc >= 0 && nc < n) {

                            int id = grid[nr][nc];

                            if (id > 1 && seen.add(id)) {
                                area += areaMap.get(id);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, int r, int c, int id) {
        if (r < 0 || r >= n || c < 0 || c >= n ||
            grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = id;
        int area = 1;

        for (int[] dir : directions) {
            area += dfs(grid, r + dir[0], c + dir[1], id);
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };

        System.out.println(largestIsland(grid));
    }
}
