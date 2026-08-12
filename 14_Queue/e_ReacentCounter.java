import java.util.*;

public class e_ReacentCounter {

    static class RecentCounter {

        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {

            q.add(t);

            while (q.peek() < t - 3000) {
                q.poll();
            }

            return q.size();
        }
    }

    public static void main(String[] args) {

        RecentCounter obj = new RecentCounter();

        System.out.println(obj.ping(1));     // 1
        System.out.println(obj.ping(100));   // 2
        System.out.println(obj.ping(3001));  // 3
        System.out.println(obj.ping(3002));  // 3
    }
}