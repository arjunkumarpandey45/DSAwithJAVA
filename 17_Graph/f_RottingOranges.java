import java.util.*;

public class f_RottingOranges {

    static class Pair {
        int first;
        int second;
        int third; // time

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];

        int cntFresh = 0;

        // Put ALL initially rotten oranges into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        int tm = 0;
        int cntRotten = 0;

        // Multi-source BFS
        while (!q.isEmpty()) {

            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().third;

            q.poll();

            tm = Math.max(tm, t);

            for (int i = 0; i < 4; i++) {

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1) {

                    vis[nrow][ncol] = 2;

                    cntRotten++;

                    // One minute after current orange
                    q.add(new Pair(nrow, ncol, t + 1));
                }
            }
        }

        if (cntFresh != cntRotten) {
            return -1;
        }

        return tm;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int ans = orangesRotting(grid);

        System.out.println("Minimum time: " + ans);
    }
}