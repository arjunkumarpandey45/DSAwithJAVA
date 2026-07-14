
public class j_KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int hour = 6;
        System.out.println(kokoEatingBanana(piles, hour));
    }
    public static int kokoEatingBanana(int[] piles, int hour) {
        int highestElement =findMax(piles);
        int low = 1;
        int high = highestElement;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long currentHour = calculateTotalHours(piles, mid);
            if (currentHour <= hour) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static long calculateTotalHours(int[] piles, int speed) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile - 1L) / speed + 1;
        }

        return totalHours;
    }
      public static int findMax(int[] piles) {
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }
}