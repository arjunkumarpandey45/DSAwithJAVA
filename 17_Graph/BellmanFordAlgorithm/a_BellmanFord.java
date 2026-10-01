package BellmanFordAlgorithm;

import java.util.*;

public class a_BellmanFord {

    static class Edge {

        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void bellmanFord(
            int vertices,
            ArrayList<Edge> edges,
            int source) {

        // Step 1: Initially all distances are infinity
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source distance = 0
        dist[source] = 0;

        // Step 2: Relax all edges V - 1 times
        for (int i = 1; i <= vertices - 1; i++) {

            boolean changed = false;

            for (Edge edge : edges) {

                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;

                // Relaxation
                if (dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                    changed = true;
                }
            }

            // If no distance changed, shortest paths are finalized
            if (!changed) {
                break;
            }
        }

        // Step 3: Check for negative-weight cycle
        for (Edge edge : edges) {

            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;

            if (dist[u] != Integer.MAX_VALUE
                    && dist[u] + weight < dist[v]) {

                System.out.println("Negative weight cycle detected.");
                return;
            }
        }

        // Step 4: Print shortest distances
        System.out.println("Shortest distances:");

        for (int i = 0; i < vertices; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(source + " -> " + i + " = INF");
            } else {
                System.out.println(source + " -> " + i + " = " + dist[i]);
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 3;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(1, 2, -2));

        int source = 0;

        bellmanFord(vertices, edges, source);
    }
}