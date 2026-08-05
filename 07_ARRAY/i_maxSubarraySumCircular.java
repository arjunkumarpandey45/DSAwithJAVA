import java.util.*;

public class i_maxSubarraySumCircular {

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int currentMin = nums[0];
        int currentMax = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            total += nums[i];
        }

        int circularSum = total - minSum;

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, circularSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Size of array
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maxSubarraySumCircular(nums));

        sc.close();
    }
}