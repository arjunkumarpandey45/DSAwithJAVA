public class i_SquareRoot {
    public static void main(String[] args) {
        int x=81;
        System.out.println(mySqrt(x));
    }
     public static int mySqrt(int x) {
        int ans = 0;
        long low = 0;
        long high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                ans=(int)mid;
                low = mid + 1;
            }

        }

        return ans;
    }
}
