package zDailyQuiz;


public class DQ33_CalculateDigitSumOfString {

    public String sum(String s, int k) {
        int n = s.length();
        int sum = 0;
        int c = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
            c++;

            if (c == k) {
                c = 0;
                sb.append(sum);
                sum = 0;
            }
        }

        if (c > 0) {
            sb.append(sum);
        }

        return sb.toString();
    }

    public String digitSum(String s, int k) {
        int n = s.length();

        if (n < k) {
            return s;
        }

        String newS = s;

        while (n > k) {
            newS = sum(newS, k);
            n = newS.length();

            if (n == k) {
                return newS;
            }
        }

        return newS;
    }

    public static void main(String[] args) {

        DQ33_CalculateDigitSumOfString obj = new DQ33_CalculateDigitSumOfString();

        String s = "11111222223";
        int k = 3;

        String result = obj.digitSum(s, k);

        System.out.println("Result: " + result);
    }
}

