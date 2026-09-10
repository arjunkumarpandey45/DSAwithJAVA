public class t_CountNodeEqAvgSubTree {

    static int ans = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int sum = left[0] + right[0] + node.val;
        int cnt = left[1] + right[1] + 1;

        if (sum / cnt == node.val) {
            ans++;
        }

        return new int[]{sum, cnt};
    }

    public static void main(String[] args) {

        /*
                4
               / \
              8   5
             / \   \
            0   1   6
        */

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(6);

        System.out.println(averageOfSubtree(root));
    }
}