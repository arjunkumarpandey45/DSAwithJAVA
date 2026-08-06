import java.util.*;

public class m_SumofSubarrayRanges {

    public static int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] previousGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    public static long subArrayRanges(int[] arr) {
        long contribution = 0;

        int[] psi = previousSmaller(arr);
        int[] nsi = nextSmaller(arr);
        int[] pgi = previousGreater(arr);
        int[] ngi = nextGreater(arr);

        for (int i = 0; i < arr.length; i++) {

            long leftS = i - psi[i];
            long rightS = nsi[i] - i;

            long leftG = i - pgi[i];
            long rightG = ngi[i] - i;

            long minContribution = 1L * arr[i] * leftS * rightS;
            long maxContribution = 1L * arr[i] * leftG * rightG;

            contribution += (maxContribution - minContribution);
        }

        return contribution;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(subArrayRanges(arr));

        sc.close();
    }
}