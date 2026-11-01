package zDailyQuiz;



public class DQ22_MinimumMovesToEqualArrayElements {

    public static int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }

        return sum - nums.length * min;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        int result = minMoves(nums);

        System.out.println("Minimum Moves: " + result);
    }
}
