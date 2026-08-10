public class a_QueueImplementation {

    // ================= ARRAY QUEUE =================
    static class ArrayQueue {

        int[] arr;
        int front = 0;
        int rear = -1;
        int size = 0;

        ArrayQueue(int capacity) {
            arr = new int[capacity];
        }

        // add -> element insert
        void add(int value) {
            if (size == arr.length) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = value;
            size++;
        }

        // remove -> front element remove
        int remove() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            int value = arr[front];
            front++;
            size--;

            return value;
        }

        // poll -> same as remove, but empty hone par -1
        int poll() {
            if (size == 0) {
                return -1;
            }

            return remove();
        }

        // peek -> front element dekho, remove nahi hoga
        int peek() {
            if (size == 0) {
                return -1;
            }

            return arr[front];
        }

        // size
        int size() {
            return size;
        }

        // empty check
        boolean isEmpty() {
            return size == 0;
        }
    }


    // ================= LINKED LIST QUEUE =================
    static class LinkedQueue {

        Node front;
        Node rear;
        int size = 0;

        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        // add -> rear par add
        void add(int value) {

            Node newNode = new Node(value);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }

            size++;
        }

        // remove -> front se remove
        int remove() {

            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }

            int value = front.data;

            front = front.next;

            if (front == null) {
                rear = null;
            }

            size--;

            return value;
        }

        // poll
        int poll() {

            if (front == null) {
                return -1;
            }

            return remove();
        }

        // peek
        int peek() {

            if (front == null) {
                return -1;
            }

            return front.data;
        }

        // size
        int size() {
            return size;
        }

        // empty check
        boolean isEmpty() {
            return front == null;
        }
    }


    // ================= MAIN =================
    public static void main(String[] args) {

        ArrayQueue q1 = new ArrayQueue(5);

        q1.add(10);
        q1.add(20);
        q1.add(30);

        System.out.println(q1.peek());     // 10
        System.out.println(q1.poll());     // 10
        System.out.println(q1.remove());   // 20
        System.out.println(q1.size());     // 1
        System.out.println(q1.isEmpty());  // false


        System.out.println();


        LinkedQueue q2 = new LinkedQueue();

        q2.add(10);
        q2.add(20);
        q2.add(30);

        System.out.println(q2.peek());     // 10
        System.out.println(q2.poll());     // 10
        System.out.println(q2.remove());   // 20
        System.out.println(q2.size());     // 1
        System.out.println(q2.isEmpty());  // false
    }
}