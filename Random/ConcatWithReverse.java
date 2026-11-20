package Random;


import java.util.Arrays;

public class ConcatWithReverse{

    public static int[] concatWithReverse(int[] nums) {

        int[] ans = new int[nums.length * 2];
        int index = 0;

      
        for (int i = 0; i < nums.length; i++) {
            ans[index++] = nums[i];
        }

       
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[index++] = nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        int[] result = concatWithReverse(nums);

        System.out.println(Arrays.toString(result));
    }
}
