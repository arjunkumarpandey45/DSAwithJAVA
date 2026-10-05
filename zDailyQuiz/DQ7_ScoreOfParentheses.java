package zDailyQuiz;

import java.util.Stack;

public class DQ7_ScoreOfParentheses {

    public static int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(0);
            } 
            else {
                int inside = st.pop();

                int score;

                if (inside == 0) {
                    score = 1;          // ()
                } else {
                    score = 2 * inside; // (A)
                }

                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {

        System.out.println(scoreOfParentheses("()"));       // 1
        System.out.println(scoreOfParentheses("(())"));     // 2
        System.out.println(scoreOfParentheses("()()"));     // 2
        System.out.println(scoreOfParentheses("(()())"));   // 4
        System.out.println(scoreOfParentheses("((()))"));   // 4
    }
}
