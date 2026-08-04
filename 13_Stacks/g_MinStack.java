
import java.util.Stack;

public class g_MinStack {

    private Stack<Long> st;
    private long min;

    public g_MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        if (st.isEmpty()) {
            st.push((long) value);
            min = value;
            return;
        }

        if (value < min) {
            st.push(2L * value - min);
            min = value;
        } else {
            st.push((long) value);
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        if (st.peek() < min) {
            min = 2 * min - st.peek();
        }

        st.pop();
    }

    public int top() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        if (st.peek() >= min) {
            return st.peek().intValue();
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return (int) min;
    }

    public static void main(String[] args) {

        g_MinStack obj = new g_MinStack();

        obj.push(5);
        System.out.println("Min = " + obj.getMin());

        obj.push(3);
        System.out.println("Min = " + obj.getMin());

        obj.push(7);
        System.out.println("Top = " + obj.top());

        obj.push(2);
        System.out.println("Min = " + obj.getMin());

        obj.pop();
        System.out.println("After Pop");
        System.out.println("Top = " + obj.top());
        System.out.println("Min = " + obj.getMin());

        obj.pop();
        System.out.println("After Pop");
        System.out.println("Top = " + obj.top());
        System.out.println("Min = " + obj.getMin());
    }
}