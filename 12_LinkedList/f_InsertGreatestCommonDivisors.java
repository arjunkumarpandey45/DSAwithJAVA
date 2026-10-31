
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class f_InsertGreatestCommonDivisors {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int v1 = gcd(curr.val, curr.next.val);

            ListNode v = new ListNode(v1);

            ListNode temp = curr.next;
            curr.next = v;
            v.next = temp;

            curr = temp;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head = insertGreatestCommonDivisors(head);

        System.out.println("Modified List:");
        printList(head);
    }
}
