import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class v_RepeatingAndMissingEle {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 2, 1 };
        System.out.println(repeatingAndMissingEleOptimal2(arr));
        ;
    }

    public static ArrayList<Integer> repeatingAndMissingEleBetter(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int missing = 0;
        int totalSum = 0;
        int repeat = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            if (i > 0 && arr[i - 1] == arr[i]) {
                repeat = arr[i];
                ans.add(arr[i]);

            }
        }
        System.out.println("Total s " + totalSum);
        int m = arr.length;
        int totalSumToN = (m * (m + 1)) / 2;
        System.out.println("Total s " + totalSumToN);
        missing = totalSumToN - totalSum + repeat;
        ans.add(missing);
        return ans;
    }

    public static ArrayList<Integer> repeatingAndMissingEleOptimal(int[] arr) {
        int n = arr.length;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : arr) {
            actualSum += num;
            actualSquareSum += 1L * num * num;
        }

        long expectedSum = 1L * n * (n + 1) / 2;
        long expectedSquareSum = 1L * n * (n + 1) * (2L * n + 1) / 6;

        long diff = expectedSum - actualSum; // x - y

        long squareDiff = expectedSquareSum - actualSquareSum; // x² - y²

        long sum = squareDiff / diff; // x + y

        long missing = (diff + sum) / 2;
        long repeating = missing - diff;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) repeating);
        ans.add((int) missing);

        return ans;
    }

    public static ArrayList<Integer> repeatingAndMissingEleOptimal2(int[] arr) {

        int n = arr.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }

        int bit = xor & (-xor);

        int zero = 0;
        int one = 0;

        for (int num : arr) {
            if ((num & bit) != 0)
                one ^= num;
            else
                zero ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & bit) != 0)
                one ^= i;
            else
                zero ^= i;
        }

        int repeat, missing;

        boolean found = false;

        for (int num : arr) {
            if (num == one) {
                found = true;
                break;
            }
        }

        if (found) {
            repeat = one;
            missing = zero;
        } else {
            repeat = zero;
            missing = one;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repeat);
        ans.add(missing);

        return ans;
    }
}
