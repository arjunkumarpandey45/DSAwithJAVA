package zDailyQuiz;


import java.util.*;

public class DQ32_MinimumSumSubarray {

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int currSum = 0;

            for (int j = i; j < n; j++) {

                currSum += nums.get(j);

                int length = j - i + 1;

                if (length >= l && length <= r && currSum > 0) {
                    sum = Math.min(sum, currSum);
                }
            }
        }

        return sum == Integer.MAX_VALUE ? -1 : sum;
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(3, -2, 5, -1);

        int l = 2;
        int r = 3;

        int ans = minimumSumSubarray(nums, l, r);

        System.out.println("Minimum Positive Sum: " + ans);
    }
}

