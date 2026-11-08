package zDailyQuiz;




public class DQ28_CountServersThatCommunicate {

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void unionByRank(int x, int y) {

            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return;

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }
            else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static int countServers(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int offset = rows;

        DSU dsu = new DSU(rows + cols);

        int totalServers = 0;

  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    dsu.unionByRank(i, j + offset);
                    totalServers++;
                }
            }
        }

        int[] serverCount = new int[rows + cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    int root = dsu.find(i);
                    serverCount[root]++;
                }
            }
        }

        
        int isolated = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {
                    int root = dsu.find(i);

                    if (serverCount[root] == 1) {
                        isolated++;
                    }
                }
            }
        }

        return totalServers - isolated;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {1, 0},
            {1, 1}
        };

        System.out.println(countServers(grid));
    }
}
