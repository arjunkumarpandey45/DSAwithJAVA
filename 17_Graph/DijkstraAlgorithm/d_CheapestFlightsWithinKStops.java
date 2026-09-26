package DijkstraAlgorithm;
import java.util.*;

public class d_CheapestFlightsWithinKStops {

    public static int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        // Create adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // {to, price}
        for (int[] flight : flights) {

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to, price});
        }

        /*
         * dist[city][flightsTaken]
         *
         * k stops = k + 1 maximum flights
         * flightsTaken starts from 0
         * Therefore size = k + 2
         */
        int[][] dist = new int[n][k + 2];

        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        /*
         * {city, flightsTaken, cost}
         */
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a[2], b[2])
                );

        // Starting point
        dist[src][0] = 0;

        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {

            int[] details = pq.poll();

            int city = details[0];
            int flightsTaken = details[1];
            int cost = details[2];

            // Destination reached
            if (city == dst) {
                return cost;
            }

            // Ignore outdated state
            if (cost > dist[city][flightsTaken]) {
                continue;
            }

            // Maximum flights = k + 1
            if (flightsTaken == k + 1) {
                continue;
            }

            // Explore neighbours
            for (int[] edge : graph.get(city)) {

                int nextCity = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newFlights = flightsTaken + 1;

                // Relaxation
                if (newCost < dist[nextCity][newFlights]) {

                    dist[nextCity][newFlights] = newCost;

                    pq.offer(new int[]{
                            nextCity,
                            newFlights,
                            newCost
                    });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 2, 500}
        };

        int src = 0;
        int dst = 3;
        int k = 2;

        int answer = findCheapestPrice(
                n,
                flights,
                src,
                dst,
                k
        );

        System.out.println("Cheapest Price: " + answer);
    }
}
