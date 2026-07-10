public class g_BinaraySubArraySum {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(binarySubarraySum(arr, goal));
    }

    public static int binarySubarraySum(int[] arr, int goal) {
        return atMost(arr, goal) - atMost(arr, goal - 1);
    }

    public static int atMost(int[] arr, int goal) {
        if (goal < 0)
            return 0;
        int countOfSubArr = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < arr.length) {

            sum += arr[r];
            while (sum > goal) {
                sum -= arr[l];
                l++;
            }

            countOfSubArr += (r - l + 1);
            r++;

        }
        return countOfSubArr;
    }
}
