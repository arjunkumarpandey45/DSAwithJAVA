public class a_BasicBinaryTree2 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // 1. Height / Maximum Depth
    public static int heightByLevel(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = heightByLevel(root.left);
        int rh = heightByLevel(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static int heightByEdge(Node root) {

        if (root == null) {
            return -1;
        }

        int lh = heightByEdge(root.left);
        int rh = heightByEdge(root.right);

        return 1 + Math.max(lh, rh);
    }

    // 2. Sum of all nodes
    public static int sum(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return root.data + leftSum + rightSum;
    }

    // 3. Maximum value in the tree
    public static int max(Node root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // 4. Size / Number of nodes
    public static int size(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSize = size(root.left);
        int rightSize = size(root.right);

        return 1 + leftSize + rightSize;
    }

    // 5 Min
    public static int min(Node root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = min(root.left);
        int rightMin = min(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static int product(Node root) {

        if (root == null) {
            return 1;
        }

        int leftProduct = product(root.left);
        int rightProduct = product(root.right);

        return root.data * leftProduct * rightProduct;
    }

    public static void main(String[] args) {

        /*
         * 10
         * / \
         * 5 20
         * / \ \
         * 2 8 30
         */

        Node root = new Node(10);

        root.left = new Node(5);
        root.right = new Node(20);

        root.left.left = new Node(2);
        root.left.right = new Node(8);

        root.right.right = new Node(-1);

        System.out.println("Height by edge = " + heightByEdge(root));
        System.out.println("Height by level = " + heightByLevel(root));
        System.out.println("Sum = " + sum(root));
        System.out.println("Product = " + product(root));
        System.out.println("Maximum = " + max(root));
        System.out.println("Minimum = " + min(root));
        System.out.println("Size = " + size(root));
    }
}
