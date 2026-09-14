import java.util.*;

public class h_CycleDetectionBFS {

    static List<List<Integer>> adj = new ArrayList<>();

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean bfs(int start, boolean[] visited) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.peek().node;
            int parent = q.peek().parent;

            q.poll();

            for (Integer neighbour : adj.get(node)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    q.add(new Pair(neighbour, node));

                } else if (neighbour != parent) {

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);

        boolean[] visited = new boolean[V];

        boolean cycle = false;

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (bfs(i, visited)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle exists: " + cycle);
    }
}