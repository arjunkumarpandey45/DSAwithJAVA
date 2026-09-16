import java.util.*;

public class l_BipartiteGraph {

    // =========================
    // DFS APPROACH
    // =========================

    static boolean dfs(int node, int color, int[] colors, List<List<Integer>> adj) {

        colors[node] = color;

        for (int neighbour : adj.get(node)) {

            // Not colored
            if (colors[neighbour] == 0) {

                if (!dfs(neighbour, -color, colors, adj)) {
                    return false;
                }

            }
            // Same color -> Not Bipartite
            else if (colors[neighbour] == colors[node]) {
                return false;
            }
        }

        return true;
    }

    static boolean isBipartiteDFS(int V, List<List<Integer>> adj) {

        int[] colors = new int[V];

        for (int i = 0; i < V; i++) {

            // Disconnected graph
            if (colors[i] == 0) {

                if (!dfs(i, 1, colors, adj)) {
                    return false;
                }
            }
        }

        return true;
    }


    // =========================
    // BFS APPROACH
    // =========================

    static boolean isBipartiteBFS(int V, List<List<Integer>> adj) {

        int[] colors = new int[V];

        for (int i = 0; i < V; i++) {

            // Disconnected graph
            if (colors[i] == 0) {

                Queue<Integer> q = new ArrayDeque<>();

                q.add(i);
                colors[i] = 1;

                while (!q.isEmpty()) {

                    int node = q.poll();

                    for (int neighbour : adj.get(node)) {

                        // Not colored
                        if (colors[neighbour] == 0) {

                            colors[neighbour] = -colors[node];

                            q.add(neighbour);
                        }

                        // Same color -> Not Bipartite
                        else if (colors[neighbour] == colors[node]) {

                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        int V = 4;

        List<List<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph:
        //
        //       0 -------- 1
        //       |          |
        //       |          |
        //       3 -------- 2
        //
        // Bipartite:
        // Group 1 -> 0, 2
        // Group 2 -> 1, 3

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(0);
        adj.get(0).add(3);


        // DFS
        boolean dfsResult = isBipartiteDFS(V, adj);

        System.out.println("DFS Bipartite: " + dfsResult);


        // BFS
        boolean bfsResult = isBipartiteBFS(V, adj);

        System.out.println("BFS Bipartite: " + bfsResult);
    }
}