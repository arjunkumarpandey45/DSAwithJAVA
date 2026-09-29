package zDailyQuiz;

public class DQ2_CountCommas {

    public static long countCommas(long n) {

        long ans = 0;

        if (n >= 1000) {
            ans += (n - 999);
        }

        if (n >= 1000000) {
            ans += (n - 999999);
        }

        if (n >= 1000000000) {
            ans += (n - 999999999);
        }

        if (n >= 1000000000000L) {
            ans += (n - 999999999999L);
        }

        if (n >= 1000000000000000L) {
            ans += (n - 999999999999999L);
        }

        return ans;
    }

    public static void main(String[] args) {

        long n = 1000000;

        long result = countCommas(n);

        System.out.println("Number of commas: " + result);
    }
}