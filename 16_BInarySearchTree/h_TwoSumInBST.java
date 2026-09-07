
import java.util.*;

public class h_TwoSumInBST {

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

    static class BSTIterator {

        Stack<TreeNode> st = new Stack<>();
        boolean reverse = true;

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            push(root);
        }

        public int next() {
            TreeNode temp = st.pop();

            if (reverse) {
                push(temp.left);
            } else {
                push(temp.right);
            }

            return temp.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public void push(TreeNode root) {

            while (root != null) {
                st.push(root);

                if (reverse) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
    }

    public static boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {

            if (i + j == k) {
                return true;
            } 
            else if (i + j < k) {
                i = left.next();
            } 
            else {
                j = right.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {

        /*
                 7
                / \
               3   15
              / \    \
             1   5    20

             Inorder: 1 3 5 7 15 20
        */

        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(3);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(20);

        int k = 8;

        boolean result = findTarget(root, k);

        System.out.println("Target: " + k);
        System.out.println("Pair exists: " + result);
    }
}

