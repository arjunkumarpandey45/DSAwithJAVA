import java.util.*;

public class g_BSTIterator {

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

        public BSTIterator(TreeNode root) {
            push(root);
        }

        public int next() {
            TreeNode temp = st.pop();

            push(temp.right);

            return temp.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public void push(TreeNode root) {

            while (root != null) {
                st.push(root);
                root = root.left;
            }
        }
    }

    public static void main(String[] args) {

        /*
                 7
                / \\
               3   15
              / \\    \\
             1   5    20

             Inorder: 1 3 5 7 15 20
        */

        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(3);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);

        System.out.println("BST Iterator:");

        while (obj.hasNext()) {
            System.out.print(obj.next() + " ");
        }
    }
}