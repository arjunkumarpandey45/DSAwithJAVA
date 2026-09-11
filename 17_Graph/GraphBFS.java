import java.util.*;

public class GraphBFS {

    static List<List<Integer>> adj = new ArrayList<>();

    static void bfs(int node, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            Integer nodee = q.poll();
            System.out.print(nodee + " ");
            System.out.println();
            for (Integer neighbour : adj.get(nodee)) {
                if (visited[neighbour] != true) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }

            }

        }
    }

    public static void main(String[] args) {

        int V = 5;

        // Adjacency List
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        boolean[] visited = new boolean[V];

        bfs(0, visited);
    }
}