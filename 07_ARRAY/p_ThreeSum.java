import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p_ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 2, -2 };
        System.out.println(threeSumByHasMAp(arr));
        ;
    }

    public static List<List<Integer>> threeSumByHasMAp(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < nums.length; j++) {

                int target = -(nums[i] + nums[j]);

                if (map.containsKey(target)) {
                    ans.add(Arrays.asList(nums[i], target, nums[j]));
                }

                map.put(nums[j], j);
            }
        }

        return new ArrayList<>(ans);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {

                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return ans;
    }

}
