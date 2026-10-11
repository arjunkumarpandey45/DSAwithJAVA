

public class DQ12_SumOfSquaresOfSpecialElements {

    public static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans += nums[i - 1] * nums[i - 1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int result = sumOfSquares(nums);

        System.out.println("Sum of squares: " + result);
    }
}