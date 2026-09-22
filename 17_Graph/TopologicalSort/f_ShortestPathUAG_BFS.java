package TopologicalSort;

import java.util.*;

class f_ShortestPathUAG_BFS {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int[] shortestPath(int V, int[][] edges, int source) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

          
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

   
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (Pair p : adj.get(node)) {

                int nextNode = p.node;
                int weight = p.weight;

            //    undirected + acyclic = tree/forest, source se kisi reachable node tak exactly one path hota hai.
                if (dist[nextNode] == Integer.MAX_VALUE) {

                    dist[nextNode] = dist[node] + weight;

                    q.add(nextNode);
                }
            }
        }

        
        for (int i = 0; i < V; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
                {0, 1, 2},
                {0, 3, 4},
                {1, 2, 3},
                {3, 4, 5},
                {4, 5, 2}
        };

        int source = 0;

        int[] result = shortestPath(V, edges, source);

        System.out.println(
                "Shortest distances from source " + source + ":"
        );

        System.out.println(Arrays.toString(result));
    }
}