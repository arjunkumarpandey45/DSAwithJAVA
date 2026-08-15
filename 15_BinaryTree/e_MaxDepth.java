public class e_MaxDepth {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {

        // Creating tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        int answer = maxDepth(root);

        System.out.println("Maximum Depth = " + answer);
    }
}