import java.util.HashSet;
import java.util.Set;

public class i_MaxSubArrSum {
    public static void main(String[] args) {

        int[] arr = { -2, 1, -4, -1, 2, 1, -5, 4 };
        int[] a = { 1, 5, 4, 2, 9, 9, 9 };
        int ans = maxSubArray(arr);
        maxSubArray(a, 3);

        System.out.println("Maximum Subarray Sum = " + ans);
    }

    public static int maxSubArray(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static int maxSubArray(int[] arr, int k) {
     
        for (int i = 0; i < arr.length; i++) {
            
        }
        int i = 0;
        int j = 3;
        
        return 1;
    }
}
