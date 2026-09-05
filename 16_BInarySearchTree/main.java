public class e_ValidBST {

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

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {

        if (root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val)
                && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {

        /*
                 5
                / \
               3   7
              / \ / \
             2  4 6  8

             Valid BST
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(isValidBST(root));
    }
}