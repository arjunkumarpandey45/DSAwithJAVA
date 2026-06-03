public class Triangle {
    public static void main(String[] args) {
        // rightAnglePrint(6);
        // reverseRightAngleTrangle(6);
        // printPerfectTriangle(5);
        // printPerfectReverseTriangle(5);
        // printPyramid(6);
        printRightAngleTrainleBy0and1(5);
    }

    public static void rightAnglePrint(int n) {
        // TC = O(n²) ✅ & SC = O(1) ✅
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }

    public static void reverseRightAngleTrangle(int n) {
        // TC = O(n²) ✅ & SC = O(1) ✅
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void printPerfectTriangle(int n) {
        // TC = O(n²) ✅ & SC = O(1) ✅
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("0");
            }
            System.out.println();
        }
    }

    public static void printPerfectReverseTriangle(int n) {
        
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 2 * n - i; j >= i; j--) {
                System.out.print("8");
            }
            System.out.println();
        }
    }

    public static void printPyramid(int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("8");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 2 * n - i; j >= i; j--) {
                System.out.print("8");
            }
            System.out.println();
        }

    }

    public static void printRightAngleTrainleBy0and1(int n) {
          for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print((i + j) % 2 == 0 ? "1" : "0");
        }
        System.out.println();
    }
       
    }
}
