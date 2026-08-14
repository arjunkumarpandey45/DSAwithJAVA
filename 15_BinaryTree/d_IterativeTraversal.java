import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class d_IterativeTraversal {

    // Preorder: Root -> Left -> Right
    public static List<Integer> preorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            Node current = st.pop();
            ans.add(current.data);

            // Right first because Stack is LIFO
            if (current.right != null) {
                st.push(current.right);
            }

            if (current.left != null) {
                st.push(current.left);
            }
        }

        return ans;
    }

    // Inorder: Left -> Root -> Right
    public static List<Integer> inorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        Node current = root;

        while (current != null || !st.isEmpty()) {

            // Go to the leftmost node
            while (current != null) {
                st.push(current);
                current = current.left;
            }

            // Process node
            current = st.pop();
            ans.add(current.data);

            // Move to right
            current = current.right;
        }

        return ans;
    }

    // Postorder: Left -> Right -> Root
    public static List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {

            Node current = st1.pop();
            st2.push(current);

            if (current.left != null) {
                st1.push(current.left);
            }

            if (current.right != null) {
                st1.push(current.right);
            }
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Preorder  : " + preorder(root));
        System.out.println("Inorder   : " + inorder(root));
        System.out.println("Postorder : " + postorder(root));
    }
}