
package zDailyQuiz;

import java.util.Scanner;

class DQ31_LongestMonotonicSubarray {

    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int inc = 1;
        int dec = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {

            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            }
            else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            }
            else {
                inc = 1;
                dec = 1;
            }

            max = Math.max(max, Math.max(inc, dec));
        }

        return max;
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

        int result = longestMonotonicSubarray(nums);

        System.out.println("Longest Monotonic Subarray Length: " + result);

        sc.close();
    }
}
