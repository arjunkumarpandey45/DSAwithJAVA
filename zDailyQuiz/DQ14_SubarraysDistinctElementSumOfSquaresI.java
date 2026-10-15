package zDailyQuiz;

import java.util.*;

public class DQ14_SubarraysDistinctElementSumOfSquaresI {

    public static int sumCounts(List<Integer> nums) {
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> st = new HashSet<>();

            for (int j = i; j < nums.size(); j++) {
                st.add(nums.get(j));

                int len = st.size();
                ans += len * len;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 1);

        int result = sumCounts(nums);

        System.out.println("Sum of squares: " + result);
    }
}