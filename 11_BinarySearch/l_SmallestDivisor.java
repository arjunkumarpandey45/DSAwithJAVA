public class l_SmallestDivisor {
    public static void main(String[] args) {
        int arr[] = { 44,22,33,11,1 };
        int threshold = 5;
        System.out.println(smallestDivisor(arr, threshold));
    }

    public static int smallestDivisor(int arr[], int threshold) {
        int low = 1;
        int high = arr[0];
        int minD = 0;
        for (int bloom : arr) {
         
            high = Math.max(high, bloom);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = calculateDividedSum(arr, mid);
            if (sum > threshold) {
                low = mid + 1;

            } else {
                minD = mid;
                high = mid - 1;
            }

        }
        return minD;
    }

    public static int calculateDividedSum(int[] arr,  int mid) {

        int sum = 0;
        for (int num : arr) {
            sum += (num - 1L) / mid + 1;

        }

        return sum;
    }
}
