package zDailyQuiz;

import java.util.Stack;

public class DQ5_ValidParentheses {

    public static boolean isValid(String s) {

       
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

          
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            
            else {

                
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                // Check matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // Stack should be empty after all brackets are matched
        return st.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([{}])";
        String s5 = "([)]";
        String s6 = "{[]}";

        System.out.println(s1 + " -> " + isValid(s1));
        System.out.println(s2 + " -> " + isValid(s2));
        System.out.println(s3 + " -> " + isValid(s3));
        System.out.println(s4 + " -> " + isValid(s4));
        System.out.println(s5 + " -> " + isValid(s5));
        System.out.println(s6 + " -> " + isValid(s6));
    }
}
