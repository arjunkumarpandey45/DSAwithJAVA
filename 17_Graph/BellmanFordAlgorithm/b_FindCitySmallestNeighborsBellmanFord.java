package BellmanFordAlgorithm;

import java.util.*;

public class b_FindCitySmallestNeighborsBellmanFord {

    static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

       
        List<Edge> edgeList = new ArrayList<>();

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            edgeList.add(new Edge(u, v, wt));
            edgeList.add(new Edge(v, u, wt));
        }

        int minCount = Integer.MAX_VALUE;
        int answer = -1;

       
        for (int source = 0; source < n; source++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[source] = 0;

          
            for (int i = 0; i < n - 1; i++) {

                boolean changed = false;

                for (Edge edge : edgeList) {

                    if (dist[edge.u] != Integer.MAX_VALUE &&
                            dist[edge.u] + edge.wt < dist[edge.v]) {

                        dist[edge.v] = dist[edge.u] + edge.wt;
                        changed = true;
                    }
                }

                if (!changed) {
                    break;
                }
            }

            
            int count = 0;

            for (int city = 0; city < n; city++) {

                if (dist[city] <= distanceThreshold) {
                    count++;
                }
            }

          
          
            if (count <= minCount) {
                minCount = count;
                answer = source;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };

        int distanceThreshold = 4;

        int answer = findTheCity(
                n,
                edges,
                distanceThreshold
        );

        System.out.println("Answer: " + answer);
    }
}