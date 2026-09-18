import java.util.*;

public class m_TopologicalSortDFS {

    static List<List<Integer>> adj = new ArrayList<>();

    // =========================
    // DFS TOPOLOGICAL SORT
    // =========================

    static void dfs(int node, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, visited, stack);
            }
        }

        // Node ko tab push karo jab uske
        // saare neighbours process ho jaayein
        stack.push(node);
    }

    static List<Integer> topologicalSortDFS(int V) {

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    // =========================
    // KAHN'S ALGORITHM
    // BFS TOPOLOGICAL SORT
    // =========================

    static List<Integer> topologicalSortKahn(int V) {

        // 1. Calculate indegree
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }


        // 2. Indegree 0 wale nodes Queue mein
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        // 3. BFS
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            result.add(node);

            // Neighbours ki indegree decrease karo
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                // Indegree 0 ho gayi
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }


        // 4. Cycle detection
        if (result.size() != V) {
            return new ArrayList<>();
        }

        return result;
    }


    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        int V = 6;


        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        // Graph
        adj.get(5).add(2);
        adj.get(5).add(0);

        adj.get(4).add(0);
        adj.get(4).add(1);

        adj.get(2).add(3);

        adj.get(3).add(1);


        // DFS
        List<Integer> dfsResult = topologicalSortDFS(V);

        System.out.println(
            "Topological Sort (DFS): " + dfsResult
        );


        // Kahn
        List<Integer> kahnResult = topologicalSortKahn(V);

        System.out.println(
            "Topological Sort (Kahn): " + kahnResult
        );
    }
}