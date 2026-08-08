import java.util.Stack;

public class q_RemoveKDigits {

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        String ans = removeKdigits(num, k);

        System.out.println("Result = " + ans);
    }

    public static String removeKdigits(String num, int k) {

        if (k == num.length()) {
            return "0";
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            while (!st.isEmpty()
                    && k > 0
                    && st.peek() > num.charAt(i)) {

                st.pop();
                k--;
            }

            st.push(num.charAt(i));
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        res.reverse();

        int i = 0;

        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }

        return res.substring(i);
    }
}