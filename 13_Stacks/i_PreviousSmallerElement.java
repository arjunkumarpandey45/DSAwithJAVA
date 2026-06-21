import java.util.Arrays;
import java.util.Stack;

public class i_PreviousSmallerElement {

    public static int[] previousSmaller(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int val = -1;
            while (!st.isEmpty() && arr[i] <= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                val = -1;
            } else {
                val = st.peek();
            }
            st.push(arr[i]);
            ans[i] = val;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = { 4, 5, 2, 10, 8 };
        int[] arr2 = { 1, 6, 4, 10, 2, 5 };
        int[] arr3 = { 5, 4, 3, 2, 1 };
        int[] arr4 = { 1, 2, 3, 4, 5 };

        System.out.println("Input : " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(previousSmaller(arr1)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(previousSmaller(arr2)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(previousSmaller(arr3)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(previousSmaller(arr4)));
    }
}
