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

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode sum = head;

        int carry = 0;
        while (l1 != null && l2 != null) {

            int val = l1.val + l2.val;
            if (carry + val < 10) {
                sum.val = val + carry;
                carry = 0;
            } else {
                sum.val = (carry + val) % 10;
                carry = (carry + val) / 10;
            }

            l1 = l1.next;
            l2 = l2.next;

            if (carry > 0 || l2 != null || l1 != null) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        }

        while (l1 != null) {

            int val = l1.val;
            if (carry + val < 10) {
                sum.val = val + carry;
                carry = 0;
            } else {
                sum.val = (carry + val) % 10;
                carry = (carry + val) / 10;
            }

            l1 = l1.next;

            if (carry > 0 || l1 != null) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        }

        while (l2 != null) {

            int val = l2.val;
            if (carry + val < 10) {
                sum.val = val + carry;
                carry = 0;
            } else {
                sum.val = (carry + val) % 10;
                carry = (carry + val) / 10;
            }

            l2 = l2.next;

            if (carry > 0 || l2 != null) {
                sum.next = new ListNode();
                sum = sum.next;
            }
        }

        if (carry > 0) {
            sum.val = carry;
        }

        return head;
    }
}

public class d_addTwoList {

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // l1 = 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // l2 = 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution obj = new Solution();
        ListNode ans = obj.addTwoNumbers(l1, l2);

        printList(ans); // Expected: 7 -> 0 -> 8
    }
}