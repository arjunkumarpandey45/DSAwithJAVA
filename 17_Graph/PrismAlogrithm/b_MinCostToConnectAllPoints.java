package PrismAlogrithm;

import java.util.*;

public class b_MinCostToConnectAllPoints {

    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int minCostConnectPoints(int[][] points) {

        int n = points.length;

        
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int distance =
                        Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);

                graph.get(i).add(new Edge(j, distance));
                graph.get(j).add(new Edge(i, distance));
            }
        }

        // Prim's Algorithm
        boolean[] visited = new boolean[n];

        PriorityQueue<Edge> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.weight, b.weight)
                );

        pq.offer(new Edge(0, 0));

        int minSum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            Edge current = pq.poll();

            int node = current.node;
            int weight = current.weight;

            if (visited[node]) {
                continue;
            }

            visited[node] = true;

            minSum += weight;
            count++;

            for (Edge next : graph.get(node)) {

                if (!visited[next.node]) {
                    pq.offer(next);
                }
            }
        }

        return minSum;
    }

    public static void main(String[] args) {

        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        System.out.println(minCostConnectPoints(points));
    }
}