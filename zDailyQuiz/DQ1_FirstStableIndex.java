package zDailyQuiz;

public class DQ1_FirstStableIndex {

    public static int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        int[] arr = new int[n];

        int lastMin = Integer.MAX_VALUE;

      
        for (int i = n - 1; i >= 0; i--) {
            lastMin = Math.min(lastMin, nums[i]);
            arr[i] = lastMin;
        }

        int preMax = Integer.MIN_VALUE;

       
        for (int i = 0; i < n; i++) {

            preMax = Math.max(preMax, nums[i]);

            int score = preMax - arr[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 3, 7, 2};
        int k = 4;

        int result = firstStableIndex(nums, k);

        System.out.println("First Stable Index: " + result);
    }
}