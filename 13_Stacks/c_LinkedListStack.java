public class c_LinkedListStack {

    // Node
    static class Node {
        int data;
        Node next;

        public Node(int value) {
            data = value;
            next = null;
        }
    }

    // Stack
    static class Stack {

        Node head;   // Top of Stack
        int size;

        public Stack() {
            head = null;
            size = 0;
        }

        // Push
        public void push(int value) {

            Node newNode = new Node(value);

            newNode.next = head;
            head = newNode;

            size++;
        }

        // Pop
        public int pop() {

            if (head == null) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int removedValue = head.data;

            head = head.next;

            size--;

            return removedValue;
        }

        // Peek
        public int peek() {

            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return head.data;
        }

        // isEmpty
        public boolean isEmpty() {
            return head == null;
        }

        // Size
        public int size() {
            return size;
        }

        // Display
        public void display() {

            if (head == null) {
                System.out.println("Stack is Empty");
                return;
            }

            Node temp = head;

            System.out.print("Top -> ");

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.display();

        System.out.println("Peek = " + st.peek());

        System.out.println("Pop = " + st.pop());

        st.display();

        System.out.println("Size = " + st.size());

        System.out.println("Is Empty = " + st.isEmpty());
    }
}