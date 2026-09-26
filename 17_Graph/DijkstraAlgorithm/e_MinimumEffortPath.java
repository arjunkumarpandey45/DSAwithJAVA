package DijkstraAlgorithm;


import java.util.*;

public class e_MinimumEffortPath {

    public static int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        if (n == 1 && m == 1)
            return 0;

        int[][] dist = new int[n][m];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[2] - b[2]);

        dist[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int mindiff = cur[2];

            // Stale entry
            if (mindiff > dist[r][c])
                continue;

            // Destination reached
            if (r == n - 1 && c == m - 1)
                return mindiff;

            for (int i = 0; i < 4; i++) {

                int rD = r + dr[i];
                int cD = c + dc[i];

                if (rD >= 0 && rD < n &&
                    cD >= 0 && cD < m) {

                    int currentEffort =
                            Math.abs(heights[r][c] - heights[rD][cD]);

                    int newEffort =
                            Math.max(currentEffort, mindiff);

                    if (newEffort < dist[rD][cD]) {

                        dist[rD][cD] = newEffort;

                        pq.add(new int[]{
                                rD, cD, newEffort
                        });
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {

        int[][] heights = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };

        int answer = minimumEffortPath(heights);

        System.out.println("Minimum Effort: " + answer);
    }
}