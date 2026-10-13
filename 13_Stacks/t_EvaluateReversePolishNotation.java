import java.util.Stack;

public class t_EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String i : tokens) {

            if (i.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);

            } else if (i.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b + a);

            } else if (i.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);

            } else if (i.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);

            } else {
                st.push(Integer.parseInt(i));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};

        int result = evalRPN(tokens);

        System.out.println("Result: " + result);
    }
}