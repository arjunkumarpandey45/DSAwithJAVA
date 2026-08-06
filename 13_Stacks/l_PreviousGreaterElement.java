import java.util.Arrays;
import java.util.Stack;

public class l_PreviousGreaterElement {

    public static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty()&&st.peek()<=arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i]=-1;
            }else{
               
                ans[i]=st.peek();
            }
             st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = { 4, 5, 2, 10, 8 };
        int[] arr2 = { 1, 6, 4, 10, 2, 5 };
        int[] arr3 = { 5, 4, 3, 2, 1 };
        int[] arr4 = { 1, 2, 3, 4, 5 };
        int[] arr5 = { 2, 2, 3, 1 };

        System.out.println("Input : " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(previousGreater(arr1)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(previousGreater(arr2)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(previousGreater(arr3)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(previousGreater(arr4)));
        System.out.println();

        System.out.println("Input : " + Arrays.toString(arr5));
        System.out.println("Output: " + Arrays.toString(previousGreater(arr5)));
    }
}
