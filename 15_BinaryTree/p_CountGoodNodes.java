class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class p_CountGoodNodes {

    public static int goodNodes(TreeNode root) {

        return goodNodes(root, root.val);
    }

    private static int goodNodes(TreeNode root, int max) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        // Check whether current node is a Good Node
        if (root.val >= max) {
            count = 1;
            max = root.val;
        }

        // Count Good Nodes in left subtree
        count += goodNodes(root.left, max);

        // Count Good Nodes in right subtree
        count += goodNodes(root.right, max);

        return count;
    }

    public static void main(String[] args) {

        /*
                  3
                /   \
               1     4
              /     / \
             3     1   5
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int result = goodNodes(root);

        System.out.println("Number of Good Nodes: " + result);
    }
}