import java.util.*;

class TreeNode {
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

public class m_LeftAndRightView {

    // ================= RIGHT VIEW =================

    public static void rightView(TreeNode root, List<Integer> ds, int height) {

        if (root == null) {
            return;
        }

        // First node encountered at this level
        if (ds.size() == height) {
            ds.add(root.val);
        }

        // Right first
        rightView(root.right, ds, height + 1);

        // Then left
        rightView(root.left, ds, height + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> ds = new ArrayList<>();

        rightView(root, ds, 0);

        return ds;
    }


    // ================= LEFT VIEW =================

    public static void leftView(TreeNode root, List<Integer> ds, int height) {

        if (root == null) {
            return;
        }

        // First node encountered at this level
        if (ds.size() == height) {
            ds.add(root.val);
        }

        // Left first
        leftView(root.left, ds, height + 1);

        // Then right
        leftView(root.right, ds, height + 1);
    }

    public static List<Integer> leftSideView(TreeNode root) {

        List<Integer> ds = new ArrayList<>();

        leftView(root, ds, 0);

        return ds;
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \     \
             4   5     6
                  \
                   7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.right = new TreeNode(7);


        // Left View
        List<Integer> left = leftSideView(root);

        System.out.println("Left View: " + left);


        // Right View
        List<Integer> right = rightSideView(root);

        System.out.println("Right View: " + right);
    }
}