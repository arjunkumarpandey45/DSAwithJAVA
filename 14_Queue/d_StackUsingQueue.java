import java.util.*;

public class d_StackUsingQueue {

    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            if (q1.isEmpty()) {
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int f = q1.remove();

            while (q2.size() > 0) {
                q1.add(q2.remove());
            }

            return f;
        }

        public int top() {
            if (q1.isEmpty()) {
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int f = q1.remove();

            while (q2.size() > 0) {
                q1.add(q2.remove());
            }

            q1.add(f);

            return f;
        }

        public boolean empty() {
            return q1.isEmpty();
        }


        /*
        ==================================================
                    ONE QUEUE APPROACH
        ==================================================

        Queue<Integer> q = new LinkedList<>();

        public void push(int x) {
            q.add(x);

            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.remove());
            }
        }

        public int pop() {
            if (q.isEmpty()) {
                return -1;
            }

            return q.remove();
        }

        public int top() {
            if (q.isEmpty()) {
                return -1;
            }

            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }

        */


        // ================= MAIN =================

        public static void main(String[] args) {

            MyStack obj = new MyStack();

            obj.push(10);
            obj.push(20);
            obj.push(30);

            System.out.println("Top: " + obj.top());

            System.out.println("Pop: " + obj.pop());

            System.out.println("Top: " + obj.top());

            System.out.println("Empty: " + obj.empty());

            System.out.println("Pop: " + obj.pop());
            System.out.println("Pop: " + obj.pop());

            System.out.println("Empty: " + obj.empty());
        }
    }
}