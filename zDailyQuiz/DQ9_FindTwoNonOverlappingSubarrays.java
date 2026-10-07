package zDailyQuiz;

import java.util.*;

public class DQ9_FindTwoNonOverlappingSubarrays {

    public static int minSumOfLengths(int[] arr, int target) {

        int sum = 0;
        int left = 0;

        int minL = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        int[] best = new int[arr.length];

        Arrays.fill(best, Integer.MAX_VALUE);

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int currL = right - left + 1;

             
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currL + best[left - 1]);
                }

                minL = Math.min(minL, currL);
            }

            best[right] = minL;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;

        int result = minSumOfLengths(arr, target);

        System.out.println("Minimum sum of lengths: " + result);
    }
}
