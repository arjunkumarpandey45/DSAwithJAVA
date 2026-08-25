import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class n_leftBottomValue {

    // ==================================================
    // APPROACH 1: Height + Level Traversal
    // ==================================================

    static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    static boolean nLevel(TreeNode root, int h, int[] ans) {

        if (root == null) {
            return false;
        }

        // Reached the required level
        if (h == 1) {
            ans[0] = root.val;
            return true;
        }

        // Left first
        if (nLevel(root.left, h - 1, ans)) {
            return true;
        }

        // Then right
        return nLevel(root.right, h - 1, ans);
    }

    static int findBottomLeftValue1(TreeNode root) {

        int h = height(root);

        int[] ans = new int[1];

        nLevel(root, h, ans);

        return ans[0];
    }


    // ==================================================
    // APPROACH 2: DFS + Level
    // No Global Variables
    // ==================================================

    static void view(TreeNode root, int level, int[] ans) {

        if (root == null) {
            return;
        }

        // ans[0] = maxLevel
        // ans[1] = value

        if (level > ans[0]) {
            ans[0] = level;
            ans[1] = root.val;
        }

        // Left first
        view(root.left, level + 1, ans);

        // Then right
        view(root.right, level + 1, ans);
    }

    static int findBottomLeftValue2(TreeNode root) {

        // ans[0] = maxLevel
        // ans[1] = answer

        int[] ans = {-1, 0};

        view(root, 0, ans);

        return ans[1];
    }


    // ==================================================
    // MAIN
    // ==================================================

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \     \
               4   5     6
                  /
                 7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);


        // Approach 1
        int result1 = findBottomLeftValue1(root);

        System.out.println("Approach 1: " + result1);


        // Approach 2
        int result2 = findBottomLeftValue2(root);

        System.out.println("Approach 2: " + result2);
    }
}