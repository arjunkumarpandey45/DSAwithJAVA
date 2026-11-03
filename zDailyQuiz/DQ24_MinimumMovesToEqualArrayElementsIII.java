package zDailyQuiz;



public class DQ24_MinimumMovesToEqualArrayElementsIII {

    public static int minMoves(int[] nums) {
        int max = 0;
        int total = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            total += num;
        }

        return max * nums.length - total;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 3};

        int result = minMoves(nums);

        System.out.println("Minimum Moves: " + result);
    }
}
