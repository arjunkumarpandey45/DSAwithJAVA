package zDailyQuiz;


import java.util.Arrays;

public class DQ20_MinimumCost {
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans = 0;
        int count = 2;
        for (int i = n - 1; i >= 0; i--) {
            if (count == 0) {
                count = 2;
                continue;
            }
            ans += cost[i];
            count--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] cost = {1, 2, 3, 4, 5, 6};

        System.out.println("Minimum Cost: " + minimumCost(cost));
    }
}
