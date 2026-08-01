public class b_ArrayStack {

    static class Stack {

        int[] stack;      // Stack store 
        int top;          // Top element 
        int size;         // Stack  total size

        public Stack(int stackSize) {
            stack = new int[stackSize];
            size = stackSize;
            top = -1;
        }

        // Push
        public void push(int value) {

            if (top == size - 1) {
                System.out.println("Stack Overflow");
                return;
            }

        
            stack[++top] = value;
        }

        // Pop
        public int pop() {

            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int removedValue = stack[top--];
  

            return removedValue;
        }

        // Peek
        public int peek() {

            if (top == -1) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return stack[top];
        }

        // Size
        public int size() {
            return top + 1;
        }

        // Empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Full
        public boolean isFull() {
            return top == size - 1;
        }

        // Display
        public void display() {

            if (top == -1) {
                System.out.println("Stack is Empty");
                return;
            }

            System.out.print("Top -> ");

            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack(5);

        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Peek = " + st.peek());

        System.out.println("Pop = " + st.pop());

        st.display();

        System.out.println("Size = " + st.size());

        System.out.println("Is Empty = " + st.isEmpty());

        System.out.println("Is Full = " + st.isFull());
    }
}