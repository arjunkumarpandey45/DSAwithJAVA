import java.util.*;

public class s_maxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // q.offer(i);       -> back mein add
        // q.addLast(i);     -> back mein add
        // q.offerLast(i);   -> back mein add

        // q.addFirst(i);    -> front mein add
        // q.offerFirst(i);  -> front mein add
        // q.push(i);        -> front mein add

        // q.poll();         -> front se remove
        // q.pollFirst();    -> front se remove
        // q.removeFirst();  -> front se remove
        // q.pop();          -> front se remove

        // q.pollLast();     -> back se remove
        // q.removeLast();   -> back se remove

        // q.peek();         -> front dekho
        // q.peekFirst();    -> front dekho
        // q.peekLast();     -> back dekho

        int n = nums.length;
        int[] arr = new int[n - k + 1];
        int index = 0;

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Window se bahar wale index ko remove karo
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // Current element se chhote elements useless hain
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // Current index ko deque ke back mein add karo
            q.offer(i);

            // Window complete ho gayi
            if (i >= k - 1) {
                arr[index++] = nums[q.peek()];
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}