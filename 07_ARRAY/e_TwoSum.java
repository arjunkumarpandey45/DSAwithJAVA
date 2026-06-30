import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e_TwoSum {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 18 };
        int target = 3;

        int[] result = twoSum(arr, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int check = target - arr[i];

            if (map.containsKey(check)) {
                return new int[] { map.get(check), i };
            }

            map.put(arr[i], i);
        }

        return new int[] {};
    }

    public static int[] twoSumV2(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        for (int j2 = 0; j2 < arr.length; j2++) {
            if (arr[i] + arr[j] == target) {
                return new int[] { i, j };
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{};
    }
}