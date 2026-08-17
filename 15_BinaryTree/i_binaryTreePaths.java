import java.util.*;

public class i_binaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void helper(TreeNode root, List<String> ans, String s) {

        // Agar node null hai to return
        if (root == null) {
            return;
        }

        // Agar leaf node hai
        if (root.left == null && root.right == null) {

            s += root.val;

            ans.add(s);

            return;
        }

        // Left subtree
        helper(root.left, ans, s + root.val + "->");

        // Right subtree
        helper(root.right, ans, s + root.val + "->");
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        helper(root, ans, "");

        return ans;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                   \
                    5

            Paths:
            1 -> 2 -> 5
            1 -> 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        System.out.println("Binary Tree Paths:");

        for (String path : result) {
            System.out.println(path);
        }
    }
}