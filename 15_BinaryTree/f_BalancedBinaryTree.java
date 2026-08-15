public class f_BalancedBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isBalanced(Node root) {

        if (root == null) {
            return true;
        }

        if (height(root) == -1) {
            return false;
        }

        return true;
    }

    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = height(root.left);

        if (lh == -1) {
            return -1;
        }

        int rh = height(root.right);

        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        boolean result = isBalanced(root);

        System.out.println("Is Balanced: " + result);
    }
}