package TopologicalSort;
import java.util.*;

public class c_EventualSafeStates {

    static List<List<Integer>> reverseGraph = new ArrayList<>();

    static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Reverse graph create
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        // Build reverse graph
        for (int i = 0; i < n; i++) {

            for (int neighbour : graph[i]) {

                // Original: i -> neighbour
                // Reverse:  neighbour -> i
                reverseGraph.get(neighbour).add(i);

                outdegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {

            if (outdegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Kahn's Algorithm
        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            // Reverse graph ke predecessors
            for (int neighbour : reverseGraph.get(node)) {

                outdegree[neighbour]--;

                if (outdegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        // Question requires ascending order
        Collections.sort(ans);

        return ans;
    }


    public static void main(String[] args) {

        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> result = eventualSafeNodes(graph);

        System.out.println("Safe Nodes: " + result);
    }
}