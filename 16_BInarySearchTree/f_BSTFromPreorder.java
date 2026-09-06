import java.util.*;

public class f_BSTFromPreorder {

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

    public static TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE, new int[]{0});
    }

    public static TreeNode bstFromPreorder(int[] A, int bound, int[] i) {

        if (i[0] == A.length || A[i[0]] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(A[i[0]++]);

        root.left = bstFromPreorder(A, root.val, i);

        root.right = bstFromPreorder(A, bound, i);

        return root;
    }

    // Level Order Traversal
    public static void printTree(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.print("[");

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                System.out.print("null,");
                continue;
            }

            System.out.print(current.val + ",");

            queue.add(current.left);
            queue.add(current.right);
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        /*
                 8
                / \
               5   10
              / \    \
             1   7    12
        */

        int[] A = {8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreorder(A);

        System.out.print("Input: preorder = ");
        System.out.println(Arrays.toString(A));

        System.out.print("Output: ");
        printTree(root);
    }
}