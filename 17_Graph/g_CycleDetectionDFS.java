import java.util.*;

public class g_CycleDetectionDFS {

    static List<List<Integer>> adj = new ArrayList<>();

    static boolean dfs(int node, int parent, boolean[] visited) {

        visited[node] = true;

        for (Integer neighbour : adj.get(node)) {

            if (!visited[neighbour]) {

                if (dfs(neighbour, node, visited)) {
                    return true;
                }

            } else if (neighbour != parent) {

                return true;
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

                if (dfs(i, -1, visited)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle exists: " + cycle);
    }
}