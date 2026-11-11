package zDailyQuiz;

class DQ29_MinimumOperationsToSortPermutation {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int asc = 1;
        int desc = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] == (nums[i - 1] + 1) % n) {
                asc++;
            }

            if (nums[i - 1] == (nums[i] + 1) % n) {
                desc++;
            }
        }

        if (asc == n) {
            if (nums[0] == 0) {
                return 0;
            }

            return Math.min(n - nums[0], nums[0] + 2);
        }

        if (desc == n) {
            return Math.min(n - nums[n - 1], nums[n - 1]) + 1;
        }

        return -1;
    }
}
