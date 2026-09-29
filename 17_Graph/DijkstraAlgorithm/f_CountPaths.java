package DijkstraAlgorithm;

import java.util.*;

public class f_CountPaths {

    public static int countPaths(int n, int[][] roads) {

        List<List<long[]>> graph = new ArrayList<>();

        // Create graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int i = 0; i < roads.length; i++) {

            int v = roads[i][0];
            int u = roads[i][1];
            int w = roads[i][2];

            graph.get(v).add(new long[]{u, w});
            graph.get(u).add(new long[]{v, w});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Long.compare(a[1], b[1])
                );

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new long[]{0, 0});

        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {

            long[] data = pq.poll();

            int node = (int) data[0];
            long distance = data[1];

            if (distance > dist[node]) {
                continue;
            }

            for (long[] edge : graph.get(node)) {

                int adjNode = (int) edge[0];
                long edgeWeight = edge[1];

                long newDistance = distance + edgeWeight;

                if (newDistance < dist[adjNode]) {

                    dist[adjNode] = newDistance;

                    pq.offer(new long[]{
                            adjNode,
                            newDistance
                    });

                    ways[adjNode] = ways[node];

                } else if (newDistance == dist[adjNode]) {

                    ways[adjNode] =
                            (ways[node] + ways[adjNode]) % mod;
                }
            }
        }

        return (int) ways[n - 1];
    }

    public static void main(String[] args) {

        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        int n = 7;

        int result = countPaths(n, roads);

        System.out.println("Number of shortest paths = " + result);
    }
}