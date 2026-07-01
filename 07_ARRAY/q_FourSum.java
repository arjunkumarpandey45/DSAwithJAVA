import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class q_FourSum {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 2 };
        System.out.println(fourSumBetter(arr, 8));
        ;
    }

    public static List<List<Integer>> fourSumBrute(int[] nums, int target) {

        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {

                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                        if (sum == target) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {

        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            for (int j = i + 1; j < n - 2; j++) {

                HashSet<Long> set = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long fourth = (long) target - nums[i] - nums[j] - nums[k];

                    if (set.contains(fourth)) {

                        ans.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                (int) fourth,
                                nums[k]));
                    }

                    set.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(ans);
    }

    public static List<List<Integer>> fourSumOptimal(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < arr.length - 2; j++) {
                int k = j + 1;
                int l = arr.length - 1;
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                while (k < l) {
                    long sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));

                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }
                        while (k < l && arr[l] == arr[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
