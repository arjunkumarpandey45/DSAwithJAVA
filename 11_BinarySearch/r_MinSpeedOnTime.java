public class r_MinSpeedOnTime {
    public static void main(String[] args) {
        int dist[] = { 1, 1, 100000 };
        double hour = 2.01;
        System.out.println(minSpeedOnTime(dist, hour));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) {
            return -1;
        }

        int low = 1;
        int high = 10_000_000;
        int ans = -1;
        while (low <= high) {
           
            int mid = low + (high - low) / 2;
            double currentHour = isPossible(dist, mid);
            

            if (currentHour <= hour) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }
        return ans;
    }

    public static double isPossible(int[] dist, int mid) {

        double countHour = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            countHour += Math.ceil((double) dist[i] / mid);
        }

        countHour +=(double) dist[dist.length - 1] /  mid;

        return countHour;
    };
}
