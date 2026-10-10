
package DisJoint;

class DSU {

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

    // Find ultimate parent with Path Compression
    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    // Union by Rank
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

    // Union by Size
    void unionBySize(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {

            parent[rootX] = rootY;
            size[rootY] += size[rootX];

        } else {

            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static void main(String[] args) {

        DSU dsu = new DSU(6);

        // Using Union by Rank
        dsu.unionByRank(0, 1);
        dsu.unionByRank(1, 2);

        // Using Union by Size
        dsu.unionBySize(3, 4);
        dsu.unionBySize(4, 5);

        // Check whether 0 and 2 are connected
        if (dsu.find(0) == dsu.find(2)) {
            System.out.println("0 and 2 are connected");
        } else {
            System.out.println("0 and 2 are not connected");
        }

        // Check whether 0 and 5 are connected
        if (dsu.find(0) == dsu.find(5)) {
            System.out.println("0 and 5 are connected");
        } else {
            System.out.println("0 and 5 are not connected");
        }
    }
}
