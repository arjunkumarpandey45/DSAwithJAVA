package DisJoint;
class DSU {

    int[] parent;
    int[] rank;

    // Constructor
    DSU(int n) {

        parent = new int[n];
        rank = new int[n];

        // Initially every node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find ultimate parent
    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        // Path Compression
        parent[x] = find(parent[x]);

        return parent[x];
    }

    // Union by Rank
    void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        // Already in same set
        if (rootX == rootY) {
            return;
        }

        // Smaller rank under larger rank
        if (rank[rootX] < rank[rootY]) {

            parent[rootX] = rootY;

        } else if (rank[rootX] > rank[rootY]) {

            parent[rootY] = rootX;

        } else {

            // Same rank
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }


    public static void main(String[] args) {

        DSU dsu = new DSU(6);

        // Initially:
        // {0} {1} {2} {3} {4} {5}

        dsu.union(0, 1);

        // {0,1} {2} {3} {4} {5}

        dsu.union(1, 2);

        // {0,1,2} {3} {4} {5}

        dsu.union(3, 4);

        // {0,1,2} {3,4} {5}

        dsu.union(4, 5);

        // {0,1,2} {3,4,5}


        // Check whether 0 and 2 belong
        // to the same component

        if (dsu.find(0) == dsu.find(2)) {
            System.out.println("0 and 2 are connected");
        } else {
            System.out.println("0 and 2 are not connected");
        }


        // Check 0 and 5

        if (dsu.find(0) == dsu.find(5)) {
            System.out.println("0 and 5 are connected");
        } else {
            System.out.println("0 and 5 are not connected");
        }
    }
}