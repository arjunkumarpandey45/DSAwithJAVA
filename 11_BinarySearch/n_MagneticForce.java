import java.util.Arrays;

public class n_MagneticForce {
    public static void main(String[] args) {
        int arr[] = {79,74,57,22 };
        int balls = 4;
        System.out.println(maxDistance(arr, balls));
    }

    public static int maxDistance(int arr[], int balls) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length-1] - arr[0];
        int minMax = 0;
        for (int i : arr) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, balls)) {
                System.out.println(mid);
                minMax=mid;
               low = mid + 1;
            } else {
                 high = mid - 1;
            }
        }
        return minMax;
    }

    public static boolean isPossible(int arr[], int distance, int balls) {
        int ballCount = 1;
        int lastIndex = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - lastIndex >= distance) {
                ballCount++;
                lastIndex = arr[i];
            }
            ;

        }
        return ballCount >= balls;
    }
}
