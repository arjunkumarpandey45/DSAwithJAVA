
import java.util.*;

public class c_LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int v1 = pq.poll();
            int v2 = pq.poll();

            if (v1 != v2) {
                pq.offer(v1 - v2);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println(lastStoneWeight(stones));
    }
}
