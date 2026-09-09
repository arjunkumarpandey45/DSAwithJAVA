import java.util.*;

public class i_RecoverBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void inorder(TreeNode root, TreeNode[] ans) {

        if (root == null)
            return;

        inorder(root.left, ans);

        if (ans[2] != null && ans[2].val > root.val) {

            if (ans[0] == null) {
                ans[0] = ans[2];
            }

            ans[1] = root;
        }

        ans[2] = root;

        inorder(root.right, ans);
    }

    public static void recoverTree(TreeNode root) {

        TreeNode[] ans = new TreeNode[3];

        inorder(root, ans);

        int temp = ans[0].val;
        ans[0].val = ans[1].val;
        ans[1].val = temp;
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               1   4
                  /
                 2

            Wrong BST:
            3 and 2 are swapped
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);

        System.out.println("Recovered BST Inorder:");
        printInorder(root);
    }

    public static void printInorder(TreeNode root) {

        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}