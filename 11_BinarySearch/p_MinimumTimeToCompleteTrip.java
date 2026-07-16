public class p_MinimumTimeToCompleteTrip {

    public static void main(String[] args) {

        int[] time = {1, 2, 3};
        int totalTrips = 5;

        System.out.println(minimumTime(time, totalTrips));
    }

    public static boolean isTripPossible(int[] time, long currentTime, int totalTrips) {

        long completedTrips = 0;

        for (int tripTime : time) {
            completedTrips += currentTime / tripTime;

            if (completedTrips >= totalTrips) {
                return true;
            }
        }

        return false;
    }

    public static long minimumTime(int[] time, int totalTrips) {

        long minTime = time[0];

        for (int tripTime : time) {
            minTime = Math.min(minTime, tripTime);
        }

        long low = 1;
        long high = minTime * totalTrips;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (isTripPossible(time, mid, totalTrips)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}