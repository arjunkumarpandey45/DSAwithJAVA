import java.util.*;

public class h_CycleDetectionDirectedDFS {

    static List<List<Integer>> adj = new ArrayList<>();

    static boolean dfs(int node, boolean[] visited, boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : adj.get(node)) {

            // Neighbour is not visited
            if (!visited[neighbour]) {

                if (dfs(neighbour, visited, pathVisited)) {
                    return true;
                }
            }

            // Neighbour is already in current DFS path
            else if (pathVisited[neighbour]) {

                return true;
            }
        }

        // Backtracking
        pathVisited[node] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Directed edges
        //
        // 0 → 1 → 2
        //     ↑   ↓
        //     └───┘
        //
        // Cycle: 1 → 2 → 1

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        boolean cycle = false;

        // Graph can be disconnected
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, visited, pathVisited)) {
                    cycle = true;
                    break;
                }
            }
        }

        System.out.println("Cycle exists: " + cycle);
    }
}