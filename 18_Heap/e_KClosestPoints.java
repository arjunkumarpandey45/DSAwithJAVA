
import java.util.PriorityQueue;

public class e_KClosestPoints {

    public static double dist(int x, int y) {
        int ans = (x * x) + (y * y);
        return Math.sqrt(ans);
    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(a[2], b[2])
        );

        for (int i = 0; i < points.length; i++) {

            double ans = dist(points[i][0], points[i][1]);

            pq.offer(new double[]{
                points[i][0],
                points[i][1],
                ans
            });
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {

            ans[i][0] = (int) pq.peek()[0];
            ans[i][1] = (int) pq.peek()[1];

            pq.poll();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] points = {
            {1, 3},
            {-2, 2},
            {5, 8},
            {0, 1}
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("K Closest Points:");

        for (int[] point : result) {
            System.out.println(
                "[" + point[0] + ", " + point[1] + "]"
            );
        }
    }
}
