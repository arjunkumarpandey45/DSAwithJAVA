package PrismAlogrithm;

import java.util.*;

public class a_PrimMST {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int prim(int V, ArrayList<ArrayList<Pair>> graph) {

        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

       
        pq.offer(new Pair(0, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int weight = current.weight;

           
            if (visited[node]) {
                continue;
            }

           
            visited[node] = true;
            mstWeight += weight;

          
            for (Pair neighbor : graph.get(node)) {

                if (!visited[neighbor.node]) {
                    pq.offer(
                        new Pair(neighbor.node, neighbor.weight)
                    );
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }


        graph.get(0).add(new Pair(1, 2));
        graph.get(1).add(new Pair(0, 2));

        graph.get(0).add(new Pair(2, 6));
        graph.get(2).add(new Pair(0, 6));

        graph.get(0).add(new Pair(3, 3));
        graph.get(3).add(new Pair(0, 3));

        graph.get(1).add(new Pair(3, 1));
        graph.get(3).add(new Pair(1, 1));

        graph.get(2).add(new Pair(3, 4));
        graph.get(3).add(new Pair(2, 4));

        System.out.println(prim(V, graph));
    }
}
