public class c_CircularQueue {

    int[] arr;
    int front = 0;
    int rear = -1;
    int size = 0;

    c_CircularQueue(int capacity) {
        arr = new int[capacity];
    }

    // Add element at rear
    void add(int x) {

        if (size == arr.length) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % arr.length;
        arr[rear] = x;
        size++;
    }

    // Remove element from front
    int remove() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = arr[front];

        front = (front + 1) % arr.length;
        size--;

        return value;
    }

    // Front element
    int peek() {

        if (size == 0) {
            return -1;
        }

        return arr[front];
    }

    // Number of elements
    int size() {
        return size;
    }

    // Empty check
    boolean isEmpty() {
        return size == 0;
    }

    // Full check
    boolean isFull() {
        return size == arr.length;
    }


    public static void main(String[] args) {

        c_CircularQueue q = new c_CircularQueue(6);

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q.remove()); // 10
        System.out.println(q.remove()); // 20

        q.add(60);
        q.add(70);

        System.out.println(q.peek());    // 30
        System.out.println(q.size());    // 5
    }
}