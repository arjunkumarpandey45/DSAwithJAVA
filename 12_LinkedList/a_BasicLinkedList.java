
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
        secodLast.next=null;
        return;

    }

    public static void main(String[] args) {
        a_BasicLinkedList list = new a_BasicLinkedList();
        list.addFirst("b");
        list.addFirst("a");
        list.addLast("c");
        list.deleteLast();
        // list.deleteFirst();
        // list.deleteFirst();
        list.printList();
    }
}
