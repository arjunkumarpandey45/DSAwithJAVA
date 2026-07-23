
public class a_BasicLinkedList {
    public void printList() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

    }

    Node head = null;

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;

        }
        currNode.next = newNode;

    }

    public void deleteFirst() {

        if (head == null) {
            System.out.println("List is null");
            return;
        }
        head = head.next;
        return;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is null");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secodLast = head;
        Node lasNode = head.next;
        while (lasNode.next != null) {
            lasNode = lasNode.next;
            secodLast = secodLast.next;

        }
        secodLast.next = null;
        return;

    }

    public int size() {
        int count = 0;

        Node curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public boolean search(String key) {

        Node curr = head;

        while (curr != null) {

            if (curr.data.equals(key))
                return true;

            curr = curr.next;
        }

        return false;
    }

    public void reverse() {

        if (head == null || head.next == null)
            return;

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void add(int index, String data) {

        if (index < 0 || index > size()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }
public void addBeforValue(String val,String data){
       

        if (head == null) {
            addFirst(data);
            return;
        }
          if (head.data.equals(val)) {
        addFirst(data);
        return;
    }
       Node newNode = new Node(data);
    Node curr = head;
      while (curr.next!=null) {
        if (curr.next.data.equals(val)) {
            System.out.println("Lucky Matched");
           
        newNode.next = curr.next;
        curr.next = newNode;

           return;
        }
        curr=curr.next;
        
      }
      System.out.println("error");
      return;

}
    public void delete(int index) {

        if (head == null)
            return;

        if (index < 0 || index >= size()) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
    }

    public String getFirst() {

        if (head == null)
            return null;

        return head.data;
    }

    public String getLast() {

        if (head == null)
            return null;

        Node curr = head;

        while (curr.next != null)
            curr = curr.next;

        return curr.data;
    }

    public String get(int index) {

        if (index < 0 || index >= size())
            return null;

        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.data;
    }

    public void clear() {
        head = null;
    }

    public int frequency(String key) {

        int count = 0;

        Node curr = head;

        while (curr != null) {

            if (curr.data.equals(key))
                count++;

            curr = curr.next;
        }

        return count;
    }

    public String middle() {

        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public String nthFromEnd(int n) {

        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {

            if (first == null)
                return null;

            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public boolean hasCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        a_BasicLinkedList list = new a_BasicLinkedList();
        list.addFirst("b");
        list.addFirst("a");
        list.addLast("c");
        list.addBeforValue("c","lucky");
        
        // list.deleteLast();
        // list.deleteFirst();
        // list.deleteFirst();
        list.printList();
    }
}
