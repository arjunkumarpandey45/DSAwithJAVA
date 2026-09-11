import java.util.*;

public class c_ProvisonCount {

    static void dfs(int node, int[][] isConnected, boolean[] visited) {

        visited[node] = true;

        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {

            if (isConnected[node][neighbour] == 1 && !visited[neighbour]) {
                dfs(neighbour, isConnected, visited);
            }
        }
    }

    static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int ans = findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + ans);
    }
}