public class o_SplitArray {
    public static void main(String[] args) {
        int arr[] = { 2,3,1,2,4,3 };
        int m = 5;
        System.out.println(splitArr(arr, m));
    }

    public static int splitArr(int nums[], int m) {
        
       
        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (requiresMoreThanMSubarrays(nums, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

 private static boolean requiresMoreThanMSubarrays(int[] nums, int maxAllowedSum, int m) {

        int subArrayCount = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxAllowedSum) {
                subArrayCount++;
                currentSum = num;
            } else {
                currentSum += num;
            }

            if (subArrayCount > m) {
                return true;
            }
        }

        return false;
    }
}
