public class k_mBouquets {

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(mBouquets(bloomDay, m, k));
    }

    public static int mBouquets(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }
        int low = bloomDay[0];
        int high = bloomDay[0];

        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isPossible(int[] arr, int day, int m, int k) {
        int count = 0;
        int noOfB = 0;

        for (int bloomDay : arr) {

            if (bloomDay <= day) {
                count++;
                if (count == k) {
                    noOfB++;
                    count = 0;
                    if (noOfB >= m) {
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

 
}