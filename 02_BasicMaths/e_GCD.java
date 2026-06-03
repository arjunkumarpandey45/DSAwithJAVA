public class e_GCD {
    public static void main(String[] args) {
        System.out.println("--GCD--");
        int num1 = 40;
        int num2 = 40;
        int gcd = 1;
        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
        System.out.println(gcd(num1, num2));
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
// Time Complexity: O(log(min(a,b))) ✅
// Space Complexity: O(1) (iterative)
        return gcd(b, a % b);
    }
}
