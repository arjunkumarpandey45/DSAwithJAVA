import java.util.*;

public class f_NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int val = -1;

            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                val = st.peek();
            }

            st.push(nums[i % n]);

            ans[i % n] = val;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        System.out.println(Arrays.toString(ans));
    }
}