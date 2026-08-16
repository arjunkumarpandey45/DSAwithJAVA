class g_diameterOfBinaryTree {

    static int maxDiameter = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int height(TreeNode root) {

        // Base case
        if (root == null) {
            return -1;
        }

        // Left subtree ki height
        int leftHeight = height(root.left);

        // Right subtree ki height
        int rightHeight = height(root.right);

        // Agar diameter current node ke through ja raha hai
        int currentDiameter = leftHeight + rightHeight + 2;

        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Debugging ke liye
        System.out.println(
            "Node = " + root.val +
            " | leftHeight = " + leftHeight +
            " | rightHeight = " + rightHeight +
            " | currentDiameter = " + currentDiameter +
            " | maxDiameter = " + maxDiameter
        );

        // Current node ki height parent ko return
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
              / \
             4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree(root);

        System.out.println("\nFinal Diameter = " + diameter);
    }
}