import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class d_KthSmallest {

    public static int inorder(TreeNode root, int k, int[] count) {

        if (root == null) {
            return -1;
        }

        // Left
        int left = inorder(root.left, k, count);

        if (left != -1) {
            return left;
        }

        // Root
        count[0]++;

        if (count[0] == k) {
            return root.val;
        }

        // Right
        return inorder(root.right, k, count);
    }

    public static int kthSmallest(TreeNode root, int k) {

        int[] count = {0};

        return inorder(root, k, count);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   7
             / \
            2   4

            Inorder = 2 3 4 5 7
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;

        System.out.println("Kth Smallest: " + kthSmallest(root, k));
    }
}