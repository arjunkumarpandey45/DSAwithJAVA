
public class g_DesignCircularDeque {

    int[] deque;
    int size;
    int capacity;
    int front;
    int rear;

    public g_DesignCircularDeque(int k) {
        deque = new int[k];
        size = 0;
        capacity = k;
        front = 0;
        rear = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (size == 0) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        if (size == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        deque[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
            size--;
            return true;
        }

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = 0;
            rear = -1;
            size--;
            return true;
        }

        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        g_DesignCircularDeque dq = new g_DesignCircularDeque(3);

        System.out.println(dq.insertLast(10));   // true
        System.out.println(dq.insertLast(20));   // true
        System.out.println(dq.insertFront(30));  // true
        System.out.println(dq.insertFront(40));  // false

        System.out.println(dq.getFront());       // 30
        System.out.println(dq.getRear());        // 20

        System.out.println(dq.isFull());         // true

        System.out.println(dq.deleteLast());     // true
        System.out.println(dq.insertFront(40));  // true

        System.out.println(dq.getFront());       // 40
        System.out.println(dq.getRear());        // 10
        System.out.println(dq.isEmpty());        // false
    }
}
