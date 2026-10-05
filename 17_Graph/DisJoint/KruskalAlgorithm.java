package DisJoint;

import java.util.*;

class Edge {
    int u;
    int v;
    int weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class DSU {

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

        if (parent[x] == x) {
            return x;
        }

      
        parent[x] = find(parent[x]);

        return parent[x];
    }

    void union(int x, int y) {

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
}

public class  KruskalAlgorithm {

    public static void main(String[] args) {

        int n = 4;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        
        edges.sort((a, b) -> a.weight - b.weight);

        DSU dsu = new DSU(n);

        int mstWeight = 0;
        int edgesTaken = 0;

      
        for (Edge edge : edges) {

            int rootU = dsu.find(edge.u);
            int rootV = dsu.find(edge.v);

          
            if (rootU != rootV) {

            
                dsu.union(edge.u, edge.v);

                mstWeight += edge.weight;
                edgesTaken++;

                System.out.println(
                    edge.u + " -- " + edge.v +
                    " = " + edge.weight
                );

                
                if (edgesTaken == n - 1) {
                    break;
                }
            }
        }

        System.out.println("MST Weight = " + mstWeight);
    }
}
