package zDailyQuiz;


import java.util.Arrays;

public class DQ26_FindTheDistanceValue {

    public static int DQ26_FindTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {

            int left = 0;
            int right = arr2.length;

            
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (arr2[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            boolean valid = true;

            if (left < arr2.length &&
                Math.abs((long) num - arr2[left]) <= d) {
                valid = false;
            }

            
            if (left > 0 &&
                Math.abs((long) num - arr2[left - 1]) <= d) {
                valid = false;
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;

        int result = DQ26_FindTheDistanceValue(arr1, arr2, d);

        System.out.println("Distance Value: " + result);
    }
}
