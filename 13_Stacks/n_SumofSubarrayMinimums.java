import java.util.*;

public class n_SumofSubarrayMinimums {

    public static int[] previousSmallerIndex(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] nextSmallerIndex(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;

        long ans = 0;

        int[] psi = previousSmallerIndex(arr);
        int[] nsi = nextSmallerIndex(arr);

        for (int i = 0; i < arr.length; i++) {
            long left = i - psi[i];
            long right = nsi[i] - i;

            long contribution = 1L * arr[i] * left * right;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(sumSubarrayMins(arr));

        sc.close();
    }
}