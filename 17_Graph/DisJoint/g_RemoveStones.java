package DisJoint;


import java.util.*;

public class g_RemoveStones {

    static class DSU {
        int[] parent;
        int[] rank;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }

            parent[x] = find(parent[x]);
            return parent[x];
        }

        void unionByRank(int x, int y) {
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
    }

    public static int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        int offset = maxRow + 1;
        int n = offset + maxCol + 1;

        DSU dsu = new DSU(n);

        Set<Integer> used = new HashSet<>();

        for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + offset;

            dsu.unionByRank(rowNode, colNode);

            used.add(rowNode);
            used.add(colNode);
        }

        Set<Integer> components = new HashSet<>();

        for (int node : used) {
            components.add(dsu.find(node));
        }

        return stones.length - components.size();
    }

    public static void main(String[] args) {

        int[][] stones = {
            {0, 0},
            {0, 2},
            {1, 1},
            {2, 0},
            {2, 2}
        };

        int result = removeStones(stones);

        System.out.println("Maximum stones removed: " + result);
    }
}

