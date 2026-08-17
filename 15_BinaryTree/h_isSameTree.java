public class  h_isSameTree {

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

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Dono null hain
        if (p == null && q == null) {
            return true;
        }

        // Ek null hai, dusra nahi
        if (p == null || q == null) {
            return false;
        }

        // Values different hain
        if (p.val != q.val) {
            return false;
        }

        // Left bhi same hona chahiye
        // AND
        // Right bhi same hona chahiye
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        /*
                Tree P              Tree Q

                   1                   1
                  / \                 / \
                 2   3               2   3
                /                   /
               4                   4

        */

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        q.left.left = new TreeNode(4);

        boolean result = isSameTree(p, q);

        System.out.println("Are both trees same? " + result);
    }
}