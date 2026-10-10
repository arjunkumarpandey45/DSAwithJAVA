package zDailyQuiz;


public class DQ11_RemoveOuterParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder st = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (count > 0) {
                    st.append(ch);
                }
                count++;
            } else {
                count--;
                if (count > 0) {
                    st.append(ch);
                }
            }
        }

        return st.toString();
    }

    public static void main(String[] args) {
        String s = "(()())(())";

        String result = removeOuterParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}
