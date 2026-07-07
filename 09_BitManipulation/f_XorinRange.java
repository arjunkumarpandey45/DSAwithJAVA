public class f_XorinRange {
    public static void main(String[] args) {
        // System.out.println(xorInRangeV1(4, 8));
        System.out.println(xorInRangeV2(5, 0));
    }

    public static int xorInRangeV1(int l, int r) {
        int f = xorTillN(l - 1);
        int g = xorTillN(r);
        // System.out.println(f);
        // System.out.println(g);
        int finalAns = f ^ g;
        return finalAns;

    }

    public static int xorTillN(int n) {
        switch (n % 4) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            default:
                return 0;
        }
    }

    public static int xorInRangeV2(int n, int start) {
        if (start % 2 != 0) {
            int lastValTillEnd = start + 2 * (n - 1);
            int term = (lastValTillEnd + 1) / 2;
            int v1 = xorOdd(term);
            int lastValTillStart = start - 2;
            int termv2 = (lastValTillStart + 1) / 2;
            int v2 = xorOdd(termv2);
            return v1^v2;
        }else{
            int lastValTillEnd = start + 2 * (n - 1);
            int term = (lastValTillEnd) / 2;
            int v1 = xorEven(term);
            int lastValTillStart = start - 2;
            int termv2 = (lastValTillStart ) / 2;
            int v2 = xorEven(termv2);
            return v1^v2;
        }

      
    }

    public static int xorEven(int n) {

        switch (n % 4) {
            case 0:
                return 2 * n;

            case 1:
                return 2;

            case 2:
                return 2 * n + 2;

            default: // n % 4 == 3
                return 0;
        }
    }

    public static int xorOdd(int n) {

        switch (n % 4) {
            case 0:
                return 0;

            case 1:
                return 2 * n - 1;

            case 2:
                return 2;

            default: // n % 4 == 3
                return 2 * n + 1;
        }
    }
}
