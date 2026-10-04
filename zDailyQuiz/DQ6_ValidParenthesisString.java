package zDailyQuiz;
public class DQ6_ValidParenthesisString {

    public static boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;
                high++;
            }

            low = Math.max(0, low);

            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }

    public static void main(String[] args) {

        String s = "(*))";

        boolean result = checkValidString(s);

        System.out.println(result);
    }
}