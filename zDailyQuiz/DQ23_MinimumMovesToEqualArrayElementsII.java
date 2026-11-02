package zDailyQuiz;


import java.util.Arrays;
import java.util.Scanner;

public class DQ23_MinimumMovesToEqualArrayElementsII {

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int median = 0;

        if (n % 2 != 0) {
            median = nums[n / 2];
        } else {
            median = (nums[n / 2] + nums[(n - 1) / 2]) / 2;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(median - nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Minimum Moves: " + minMoves2(nums));

        sc.close();
    }
}

