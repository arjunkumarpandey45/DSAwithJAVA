package Random;

public class HappyNumber {

    public static boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;

            while (n > 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        int n = 19;

        System.out.println(isHappy(n));
    }
}
