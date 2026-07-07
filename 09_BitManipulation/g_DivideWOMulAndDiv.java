public class g_DivideWOMulAndDiv {
    public static void main(String[] args) {

        int dividend = 22;
        int divisor = 11;
        System.out.println(divideWithoutMulAndDivOperators(dividend, divisor));
    }

    public static int divideWithoutMulAndDivOperators(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("/ by zero");
        }
        long ans = 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend >= 0) == (divisor >= 0);
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        while (n >= d) {
            int c = 0;
            while (n >= (d << (c + 1))) {
                c++;
            }
            ans += (1L << c);
            n -= (d << c);
        }

        return (int) (sign ? ans : -ans);

    }
}
