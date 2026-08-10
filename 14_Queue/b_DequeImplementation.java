import java.util.*;

public class b_DequeImplementation {

    public static void main(String[] args) {

        Deque<Integer> q = new ArrayDeque<>();

        // ================= ADD =================

        q.add(10); // back mein add
        q.offer(20); // back mein add

        q.addLast(30); // back mein add
        q.offerLast(40); // back mein add

        q.addFirst(5); // front mein add
        q.offerFirst(0); // front mein add

        // q.push(100); // front mein add

        // ================= REMOVE =================

        q.poll(); // front se remove
        q.pollFirst(); // front se remove

        q.remove(); // front se remove
        q.removeFirst(); // front se remove

        q.pop(); // front se remove

        q.pollLast(); // back se remove
        q.removeLast(); // back se remove

        // ================= PEEK =================

        q.peek(); // front dekho
        q.peekFirst(); // front dekho

        q.peekLast(); // back dekho

        // ================= OTHER =================

        q.size(); // number of elements

        q.isEmpty(); // empty hai ya nahi

        q.contains(20); // element present hai ya nahi

        q.clear(); // pura Deque empty
    }
}