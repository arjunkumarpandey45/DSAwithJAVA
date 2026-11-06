package zDailyQuiz;

import java.util.*;

public class DQ27_CountZeroRequestServers {

    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[] ans = new int[q];

        Integer[] order = new Integer[q];

        for (int i = 0; i < q; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int right = 0;
        int active = 0;

        for (int idx : order) {

            int time = queries[idx];
            int start = time - x;

            while (right < logs.length && logs[right][1] <= time) {

                int id = logs[right][0];

                if (freq.getOrDefault(id, 0) == 0) {
                    active++;
                }

                freq.put(id, freq.getOrDefault(id, 0) + 1);

                right++;
            }

            while (left < right && logs[left][1] < start) {

                int id = logs[left][0];

                freq.put(id, freq.get(id) - 1);

                if (freq.get(id) == 0) {
                    active--;
                    freq.remove(id);
                }

                left++;
            }

            ans[idx] = n - active;
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] logs = {
                { 1, 3 },
                { 2, 6 },
                { 1, 5 }
        };

        int x = 5;

        int[] queries = { 10, 11 };

        int[] result = countServers(n, logs, x, queries);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
