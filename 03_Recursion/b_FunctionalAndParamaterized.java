package Recursion;

public class
b_FunctionalAndParamaterized {
    public static void main(String[] args) {
        sumOfNumberV1(7, 0);
        System.out.println( sumOfNumberV2(7));
        System.out.println(factorialV1(10));
        factorialV2(10, 1);
    }

    public static void sumOfNumberV1(int n, int sum) {
        // Parameterized Recursion
        // TC = O(n)
        // SC = O(n)

        if (n == 0) {
            System.out.println(sum);
            return;
        }
        sum += n;

        sumOfNumberV1(n - 1, sum);

    }

    public static int sumOfNumberV2(int n) {
        // Functional Recursion
        // TC = O(n)
        // SC = O(n)
        if (n == 0) {
            return 0;
        }

        return n + sumOfNumberV2(n - 1);

    }

    public static long factorialV1(int n) {
        // Functional Recursion
        // TC = O(n)
        // SC = O(n)
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Factorial not possible for negative number");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorialV1(n - 1);
    }

    public static void factorialV2(int n, long fact) {
        // Parameterized Recursion
        // TC = O(n)
        // SC = O(n)
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Factorial not possible for negative number");
        }
        if (n <= 1) {
            System.out.println(fact);
            return;
        }
        fact *= n;
        factorialV2(n - 1, fact);

    }
}
