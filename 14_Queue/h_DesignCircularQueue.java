
public class h_DesignCircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public h_DesignCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (size == 0) {
            front = 0;
            rear = 0;
            queue[rear] = value;
            size++;
            return true;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            size--;
            front = 0;
            rear = -1;
            return true;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        h_DesignCircularQueue q = new h_DesignCircularQueue(3);

        System.out.println(q.enQueue(10)); // true
        System.out.println(q.enQueue(20)); // true
        System.out.println(q.enQueue(30)); // true
        System.out.println(q.enQueue(40)); // false

        System.out.println(q.Rear());      // 30
        System.out.println(q.isFull());    // true

        System.out.println(q.deQueue());   // true
        System.out.println(q.enQueue(40)); // true

        System.out.println(q.Front());     // 20
        System.out.println(q.Rear());      // 40
        System.out.println(q.isEmpty());   // false
    }
}
