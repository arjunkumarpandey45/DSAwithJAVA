package zDailyQuiz;


class DQ30_MinimumCostToAcquireRequiredItems {

    public static long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Case 1: Buy type 1 and type 2 separately
        long ans1 = (long) need1 * cost1
                  + (long) need2 * cost2;

        // Case 2: Buy only type 3 items
        long ans2 = (long) Math.max(need1, need2) * costBoth;

        // Case 3: Buy common items first, then remaining items
        int min = Math.min(need1, need2);

        long ans3 = (long) min * costBoth
                  + (long) (need1 - min) * cost1
                  + (long) (need2 - min) * cost2;

        return Math.min(ans1, Math.min(ans2, ans3));
    }

    public static void main(String[] args) {

        

        int cost1 = 8;
        int cost2 = 12;
        int costBoth = 5;

        int need1 = 4;
        int need2 = 2;

        long result = minimumCost(
            cost1, cost2, costBoth, need1, need2
        );

        System.out.println("Minimum Cost: " + result);
    }
}

