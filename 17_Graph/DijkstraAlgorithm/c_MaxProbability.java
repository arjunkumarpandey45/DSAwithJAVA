package DijkstraAlgorithm;
import java.util.*;

public class c_MaxProbability {

    static double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int start_node,
            int end_node) {

        
        ArrayList<ArrayList<double[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

       
        for (int i = 0; i < edges.length; i++) {

            int v = edges[i][0];
            int u = edges[i][1];
            double w = succProb[i];

            graph.get(v).add(new double[]{u, w});
            graph.get(u).add(new double[]{v, w});
        }

        
        double[] prob = new double[n];

        Arrays.fill(prob, 0.0);

        
        PriorityQueue<double[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Double.compare(b[1], a[1])
                );

      
        prob[start_node] = 1.0;

        pq.offer(new double[]{start_node, 1.0});

        
        while (!pq.isEmpty()) {

            double[] current = pq.poll();

            int node = (int) current[0];
            double probability = current[1];

            if (probability < prob[node]) {
                continue;
            }

           
            for (double[] edge : graph.get(node)) {

                int nextNode = (int) edge[0];
                double edgeProbability = edge[1];

                double newProbability =
                        probability * edgeProbability;

               
                if (newProbability > prob[nextNode]) {

                    prob[nextNode] = newProbability;

                    pq.offer(new double[]{
                            nextNode,
                            newProbability
                    });
                }
            }
        }

        return prob[end_node];
    }


    public static void main(String[] args) {

        int n = 3;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] succProb = {
                0.5,
                0.5,
                0.3
        };

        int start_node = 0;
        int end_node = 2;

        double result = maxProbability(
                n,
                edges,
                succProb,
                start_node,
                end_node
        );

        System.out.println(
                "Maximum Probability = " + result
        );
    }
}