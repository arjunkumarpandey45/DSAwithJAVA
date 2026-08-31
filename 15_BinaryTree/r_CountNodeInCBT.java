import java.util.*;

public class r_CountNodeInCBT {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == right) {
            return (int) Math.pow(2, left)
                    + countNodes(root.right);
        }

        return (int) Math.pow(2, right)
                + countNodes(root.left);
    }

    public static int getHeight(TreeNode root) {

        int height = 0;

        while (root != null) {
            height++;
            root = root.left;
        }

        return height;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }
}