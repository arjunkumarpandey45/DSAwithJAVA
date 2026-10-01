package FloydWarshallAlgorithm;

import java.util.*;

public class a_FloydWarshall {

    static void floydWarshall(int[][] graph) {

        int n = graph.length;

        // Copy graph into distance matrix
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Try every vertex as an intermediate vertex
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                    );
                }
            }
        }

        // Print shortest distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int INF = 99999;

        int[][] graph = {
                {0,   5,  10},
                {INF, 0,   3},
                {INF, INF, 0}
        };

        floydWarshall(graph);
    }
}
