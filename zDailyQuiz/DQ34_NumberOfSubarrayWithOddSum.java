package zDailyQuiz;
public class DQ34_NumberOfSubarrayWithOddSum {

    public static int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        long odd = 0;
        long even = 1;
        long sum = 0;
        long count = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                count = (count + odd) % mod;
                even++;
            } else {
                count = (count + even) % mod;
                odd++;
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int result = numOfSubarrays(arr);

        System.out.println("Number of odd sum subarrays: " + result);
    }
}
