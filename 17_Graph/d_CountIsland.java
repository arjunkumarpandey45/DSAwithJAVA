import java.util.*;

public class d_CountIsland {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void bfs(int row, int col, int[][] vis, char[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int nrow = q.peek().first;
            int ncol = q.peek().second;
            q.poll();

            for (int i = 0; i < 4; i++) {

                int r = nrow + drow[i];
                int c = ncol + dcol[i];

                if (r >= 0 && r < n &&
                    c >= 0 && c < m &&
                    vis[r][c] == 0 &&
                    grid[r][c] == '1') {

                    vis[r][c] = 1;
                    q.add(new Pair(r, c));
                }
            }
        }
    }

    static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        int[][] vis = new int[n][m];

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (vis[row][col] == 0 && grid[row][col] == '1') {

                    bfs(row, col, vis, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        int ans = numIslands(grid);

        System.out.println("Number of Islands: " + ans);
    }
}