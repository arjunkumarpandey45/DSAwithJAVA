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

public class b_DFS {

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        // Creating Binary Tree
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
                 1
                / \
               2   3
              / \ / \
             4  5 6  7
        */

        System.out.print("Preorder: ");
        preorder(root);

        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
    }
}