package zDailyQuiz;


import java.util.Scanner;

public class DQ10_minInsertions {
    public static int minInsertions(String s) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    close++;
                }

                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return close + 2 * open;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter parentheses string: ");
        String s = sc.nextLine();

        System.out.println("Minimum insertions: " + minInsertions(s));

        sc.close();
    }
}
