package DijkstraAlgorithm;

import java.util.*;

public class a_DijkstraAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[src] = 0;
        pq.offer(new int[] { src, 0 });
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];
            if (distance > dist[node]) {
                continue;
            }
            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int weight = edge[1];
                int newDistance = weight + distance;
                if (newDistance < dist[nextNode]) {
                    dist[nextNode] = newDistance;
                    pq.offer(new int[] { nextNode, newDistance });
                }

            }

        }
        return dist;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new int[] { 1, 4 });
        graph.get(0).add(new int[] { 2, 1 });

        graph.get(2).add(new int[] { 1, 2 });
        graph.get(1).add(new int[] { 3, 1 });
        graph.get(2).add(new int[] { 3, 5 });

        graph.get(3).add(new int[] { 4, 3 });

        int src = 0;

        int[] result = dijkstra(V, graph, src);

        System.out.println("Shortest distances:");

        for (int i = 0; i < V; i++) {

            if (result[i] == Integer.MAX_VALUE) {
                System.out.println(i + " -> INF");
            } else {
                System.out.println(i + " -> " + result[i]);
            }
        }
    }
}