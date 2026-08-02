class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Insert copy nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = curr.next.next;
        }

        // Step 2: Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and copied lists
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr = curr.next;
        }

        return dummy.next;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextGreaterElement'");
    }
}

public class e_Random {

    static void printList(Node head) {
        while (head != null) {
            int random = (head.random == null) ? -1 : head.random.val;
            System.out.println("Value = " + head.val + ", Random = " + random);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        // Original List: 1 -> 2 -> 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        // Random pointers
        n1.random = n3;
        n2.random = n1;
        n3.random = n2;

        Solution sol = new Solution();

        Node copied = sol.copyRandomList(n1);

        System.out.println("Original List:");
        printList(n1);

        System.out.println("\nCopied List:");
        printList(copied);
    }
}