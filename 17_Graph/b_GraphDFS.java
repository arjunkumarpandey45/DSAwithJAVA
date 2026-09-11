import java.util.*;

public class b_GraphDFS {

    static List<List<Integer>> adj = new ArrayList<>();

    static void dfs(int node, boolean[] visited) {

       visited[node]=true;
       System.out.println(node);
       for(Integer i:adj.get(node)){
        if(visited[i]!=true){
            dfs(i, visited);
        }
       }


    }

    public static void main(String[] args) {

        int V = 5;

        // Create Adjacency List
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected Edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(1).add(4);
        adj.get(4).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        boolean[] visited = new boolean[V];

        dfs(0, visited);
    }
}