package zDailyQuiz;

public class DQ8_MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {
        int plus = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
            } else {
                if (count < 1) {
                    plus++;
                } else {
                    count--;
                }
            }
        }

        return count + plus;
    }

    public static void main(String[] args) {

        String s = "()))((";

        int result = minAddToMakeValid(s);

        System.out.println("Input: " + s);
        System.out.println("Minimum additions required: " + result);
    }
}
