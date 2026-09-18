import java.util.*;

public class m_CourseSchedule {

    static List<List<Integer>> adj = new ArrayList<>();



    // COURSE SCHEDULE I - DFS
    

    static boolean[] visited;
    static boolean[] path;

    static boolean dfsCycle(int node) {

        visited[node] = true;
        path[node] = true;

        for (int neighbour : adj.get(node)) {

            // Cycle found
            if (path[neighbour]) {
                return true;
            }

            if (!visited[neighbour]) {

                if (dfsCycle(neighbour)) {
                    return true;
                }
            }
        }

        path[node] = false;

        return false;
    }

    static boolean courseScheduleDFS(int V) {

        visited = new boolean[V];
        path = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfsCycle(i)) {
                    return false;
                }
            }
        }

        return true;
    }


    
    // COURSE SCHEDULE I - BFS / KAHN'S ALGORITHM
   

    static boolean courseScheduleBFS(int V) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Indegree 0 nodes
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return count == V;
    }


  
    // COURSE SCHEDULE II - DFS
    

    static Stack<Integer> stack;

    static boolean dfsOrder(int node) {

        visited[node] = true;
        path[node] = true;

        for (int neighbour : adj.get(node)) {

            // Cycle
            if (path[neighbour]) {
                return false;
            }

            if (!visited[neighbour]) {

                if (!dfsOrder(neighbour)) {
                    return false;
                }
            }
        }

        path[node] = false;

        // All neighbours completed
        stack.push(node);

        return true;
    }

    static List<Integer> courseScheduleIIDFS(int V) {

        visited = new boolean[V];
        path = new boolean[V];
        stack = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (!dfsOrder(i)) {
                    return new ArrayList<>();
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }


    
    // COURSE SCHEDULE II - BFS / KAHN'S ALGORITHM
   

    static List<Integer> courseScheduleIIBFS(int V) {

        int[] indegree = new int[V];

        // Calculate indegree
        for (int i = 0; i < V; i++) {

            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Indegree 0 nodes
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            result.add(node);

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        // Cycle
        if (result.size() != V) {
            return new ArrayList<>();
        }

        return result;
    }




    public static void main(String[] args) {

        int V = 4;

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(2).add(3);


        // =====================================================
        // COURSE SCHEDULE I
        // =====================================================

        boolean dfsResult = courseScheduleDFS(V);

        boolean bfsResult = courseScheduleBFS(V);

        System.out.println(
                "Course Schedule I - DFS: " + dfsResult
        );

        System.out.println(
                "Course Schedule I - BFS: " + bfsResult
        );


        // =====================================================
        // COURSE SCHEDULE II
        // =====================================================

        List<Integer> dfsOrder = courseScheduleIIDFS(V);

        List<Integer> bfsOrder = courseScheduleIIBFS(V);

        System.out.println(
                "Course Schedule II - DFS: " + dfsOrder
        );

        System.out.println(
                "Course Schedule II - BFS: " + bfsOrder
        );
    }
}