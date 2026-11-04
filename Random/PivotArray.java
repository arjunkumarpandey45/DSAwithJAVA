package Random;


import java.util.Arrays;

public class PivotArray {

    public static int[] pivotArray(int[] nums, int pivot) {

        int n = nums.length;
        int[] ans = new int[n];
        int idx = 0;

        // 1. Elements smaller than pivot
        for (int num : nums) {
            if (num < pivot) {
                ans[idx++] = num;
            }
        }

        // 2. Elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                ans[idx++] = num;
            }
        }

        // 3. Elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                ans[idx++] = num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);

        System.out.println(Arrays.toString(result));
    }
}
