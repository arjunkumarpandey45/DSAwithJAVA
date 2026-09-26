package DijkstraAlgorithm;
import java.util.*;

public class d_ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        if (n == 1)
            return 1;

        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        Queue<int[]> q = new LinkedList<>();

        dist[0][0] = 1;

        q.add(new int[]{0, 0, 1});

        int[] dr = {-1, -1, 0, -1, 1, 1, 0, 1};
        int[] dc = {0, -1, 1, 1, 0, -1, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int dis = cur[2];

            for (int i = 0; i < 8; i++) {

                int rD = r + dr[i];
                int cD = c + dc[i];

                if (cD >= 0 && cD < n &&
                    rD >= 0 && rD < n &&
                    grid[rD][cD] == 0 &&
                    dis + 1 < dist[rD][cD]) {

                    dist[rD][cD] = dis + 1;

                    if (rD == n - 1 && cD == n - 1)
                        return dis + 1;

                    q.add(new int[]{rD, cD, dis + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 1},
            {1, 0}
        };

        int answer = shortestPathBinaryMatrix(grid);

        System.out.println("Shortest Path: " + answer);
    }
}