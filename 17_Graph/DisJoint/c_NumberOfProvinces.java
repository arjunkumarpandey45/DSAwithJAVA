package DisJoint;

import java.util.Arrays;

public class c_NumberOfProvinces {

    static int[] parent;
    static int[] rank;

    static int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        // Path Compression
        parent[x] = find(parent[x]);

        return parent[x];
    }

    static void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        // Union by Rank
        if (rank[rootX] < rank[rootY]) {

            parent[rootX] = rootY;

        } else if (rank[rootX] > rank[rootY]) {

            parent[rootY] = rootX;

        } else {

            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        parent = new int[n];
        rank = new int[n];

        // Initially every city is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int provinces = n;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (isConnected[i][j] == 1) {

                    if (find(i) != find(j)) {

                        union(i, j);

                        provinces--;
                    }
                }
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int answer = findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + answer);

        System.out.println("Parent Array: " + Arrays.toString(parent));
        System.out.println("Rank Array: " + Arrays.toString(rank));
    }
}