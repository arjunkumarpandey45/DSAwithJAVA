
import java.util.*;

public class b_FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        for (int num : nums) {
            pq.offer(num);
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}

