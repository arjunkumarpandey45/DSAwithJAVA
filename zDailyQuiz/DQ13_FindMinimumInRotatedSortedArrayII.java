package zDailyQuiz;


import java.util.Arrays;

public class DQ13_FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else if (nums[high] > nums[mid]) {
                high = mid;
            } else {
                high--;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 1};

        int result = findMin(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Minimum element: " + result);
    }
}

