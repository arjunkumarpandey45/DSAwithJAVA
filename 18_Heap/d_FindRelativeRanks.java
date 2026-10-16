

import java.util.*;

public class d_FindRelativeRanks {

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(score[b], score[a])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        int rank = 0;

        while (!pq.isEmpty()) {
            int index = pq.poll();

            if (rank == 0) {
                ans[index] = "Gold Medal";
            } else if (rank == 1) {
                ans[index] = "Silver Medal";
            } else if (rank == 2) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(rank + 1);
            }

            rank++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};

        System.out.println(
            Arrays.toString(findRelativeRanks(score))
        );
    }
}
