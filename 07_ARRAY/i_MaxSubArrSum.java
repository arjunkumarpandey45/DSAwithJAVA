public class i_MaxSubArrSum {
    public static void main(String[] args) {

        int[] arr = {-2, 1, -4, -1, 2, 1, -5, 4};

        int ans = maxSubArray(arr);

        System.out.println("Maximum Subarray Sum = " + ans);
    }

    public static int maxSubArray(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
