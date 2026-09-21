package TopologicalSort;

import java.util.*;

class ShortestPathDAG_DFS {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {

      
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        
        dist[0] = 0;

          while (!stack.isEmpty()) {

            int u = stack.pop();

            if (dist[u] == Integer.MAX_VALUE) {
                continue;
            }

            for (Pair p : adj.get(u)) {

                int v = p.node;
                int wt = p.weight;

                
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
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

    private void topoSort(
            int node,
            ArrayList<ArrayList<Pair>> adj,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[node] = true;

        for (Pair p : adj.get(node)) {

            if (!visited[p.node]) {
                topoSort(p.node, adj, visited, stack);
            }
        }

        stack.push(node);
    }


   
    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {1, 2, 3},
                {2, 3, 6},
                {4, 2, 2},
                {4, 5, 4},
                {5, 3, 1}
        };

        int E = edges.length;

        ShortestPathDAG_DFS obj = new ShortestPathDAG_DFS();

        int[] result = obj.shortestPath(V, E, edges);

        System.out.println("Shortest distances from source 0:");

        System.out.println(Arrays.toString(result));
    }
}