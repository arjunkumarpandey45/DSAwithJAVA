import java.util.HashMap;
import java.util.Stack;

public class e_NextGreaterElementI{

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] arr = new int[nums2.length];
        int[] ans = new int[nums1.length];

        int n = nums2.length;

        // Find next greater element for every element in nums2
        for (int i = n - 1; i >= 0; i--) {

            int val = -1;

            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }

            if (!st.isEmpty()) {
                val = st.peek();
            }

            st.push(nums2[i]);
            arr[i] = val;
        }

        // Store mapping: element -> next greater element
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], arr[i]);
        }

        // Build answer for nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = obj.nextGreaterElement(nums1, nums2);

        System.out.print("Answer: ");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}