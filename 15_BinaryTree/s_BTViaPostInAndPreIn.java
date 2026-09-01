import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class s_BTViaPostInAndPreIn {

    public static Node helperPostIn(
            int[] inorder, int inlo, int inhi,
            int[] postorder, int postlo, int posthi) {

        if (postlo > posthi) {
            return null;
        }

        Node root = new Node(postorder[posthi]);

        int i = inlo;

        while (inorder[i] != postorder[posthi]) {
            i++;
        }

        int leftSize = i - inlo;

        root.left = helperPostIn(
                inorder, inlo, i - 1,
                postorder, postlo, postlo + leftSize - 1
        );

        root.right = helperPostIn(
                inorder, i + 1, inhi,
                postorder, postlo + leftSize, posthi - 1
        );

        return root;
    }

    public static Node buildTreePostIn(
            int[] inorder,
            int[] postorder) {

        int n = inorder.length;

        return helperPostIn(
                inorder, 0, n - 1,
                postorder, 0, n - 1
        );
    }

    public static Node helperPreIn(
            int[] preorder, int prelo, int prehi,
            int[] inorder, int inlo, int inhi) {

        if (prelo > prehi) {
            return null;
        }

        Node root = new Node(preorder[prelo]);

        int i = inlo;

        while (inorder[i] != preorder[prelo]) {
            i++;
        }

        int leftSize = i - inlo;

        root.left = helperPreIn(
                preorder, prelo + 1, prelo + leftSize,
                inorder, inlo, i - 1
        );

        root.right = helperPreIn(
                preorder, prelo + leftSize + 1, prehi,
                inorder, i + 1, inhi
        );

        return root;
    }

    public static Node buildTreePreIn(
            int[] preorder,
            int[] inorder) {

        int n = inorder.length;

        return helperPreIn(
                preorder, 0, n - 1,
                inorder, 0, n - 1
        );
    }

    public static void printInorder(Node root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};

        int[] postorder = {9, 15, 7, 20, 3};

        Node root1 = buildTreePostIn(inorder, postorder);

        System.out.print("Using Inorder + Postorder: ");
        printInorder(root1);

        System.out.println();

        int[] preorder = {3, 9, 20, 15, 7};

        Node root2 = buildTreePreIn(preorder, inorder);

        System.out.print("Using Preorder + Inorder: ");
        printInorder(root2);
    }
}