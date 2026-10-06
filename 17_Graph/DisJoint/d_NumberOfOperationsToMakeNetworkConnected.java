package DisJoint;



public class d_NumberOfOperationsToMakeNetworkConnected {

    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;

        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;

        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    static int makeConnected(int n, int[][] connections) {

        // Not enough cables
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        // Initially every computer is its own component
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Connect computers using DSU
        for (int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        // Count connected components
        int components = n;

        for (int i = 0; i < n; i++) {
            if (find(i) != i) {
                components--;
            }
        }

        // Need components - 1 operations
        return components - 1;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] connections = {
            {0, 1},
            {0, 2},
            {1, 2}
        };

        int answer = makeConnected(n, connections);

        System.out.println("Minimum operations: " + answer);
    }
}