import java.util.Stack;

public class f_ImplementQueueUsingStacks {

    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }

            int f = s1.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return f;
        }

        public int peek() {
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }

            int f = s1.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return f;
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();

        obj.push(1);
        obj.push(2);
        obj.push(3);

        System.out.println("Front element: " + obj.peek());
        System.out.println("Removed element: " + obj.pop());
        System.out.println("Removed element: " + obj.pop());
        System.out.println("Is queue empty? " + obj.empty());
        System.out.println("Removed element: " + obj.pop());
        System.out.println("Is queue empty? " + obj.empty());
    }
}