package DijkstraAlgorithm;
import java.util.*;

public class b_NetworkDelayTime {

    static int networkDelayTime(int[][] times, int n, int k) {

      
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

       
        for (int i = 0; i < times.length; i++) {

            int v = times[i][0];
            int u = times[i][1];
            int w = times[i][2];

            graph.get(v).add(new int[]{u, w});
        }

        
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a[1], b[1])
                );

       
        dist[k] = 0;

        pq.offer(new int[]{k, 0});

      
        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) {
                continue;
            }

        
            for (int[] edge : graph.get(node)) {

                int nextNode = edge[0];
                int weight = edge[1];

                int newDistance = distance + weight;

               
                if (newDistance < dist[nextNode]) {

                    dist[nextNode] = newDistance;

                    pq.offer(new int[]{
                            nextNode,
                            newDistance
                    });
                }
            }
        }

       
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }


    public static void main(String[] args) {

        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        int result = networkDelayTime(times, n, k);

        System.out.println("Network Delay Time = " + result);
    }
}