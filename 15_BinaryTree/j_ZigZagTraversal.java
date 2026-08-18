import java.util.*;

public class j_ZigZagTraversal {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // =========================================================
    // V1 - DFS Approach
    // Time: O(N * H)
    // =========================================================

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    static void nLevel(TreeNode root, int h, List<Integer> row) {
        if (root == null) {
            return;
        }

        if (h == 1) {
            row.add(root.val);
            return;
        }

        nLevel(root.left, h - 1, row);
        nLevel(root.right, h - 1, row);
    }

    static void nLevel2(TreeNode root, int h, List<Integer> row) {
        if (root == null) {
            return;
        }

        if (h == 1) {
            row.add(root.val);
            return;
        }

        nLevel2(root.right, h - 1, row);
        nLevel2(root.left, h - 1, row);
    }

    static List<List<Integer>> zigzagV1(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        int h = height(root);

        for (int i = 1; i <= h; i++) {

            List<Integer> row = new ArrayList<>();

            if (i % 2 == 0) {
                nLevel2(root, i, row);
            } else {
                nLevel(root, i, row);
            }

            ans.add(row);
        }

        return ans;
    }


    // =========================================================
    // V2 - Queue + Deque Approach
    // Time: O(N)
    // =========================================================

    static List<List<Integer>> zigzagV2(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int len = q.size();

            Deque<Integer> row = new ArrayDeque<>();

            for (int i = 0; i < len; i++) {

                TreeNode node = q.poll();

                // Queue always maintains Left -> Right
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }

                // Output direction changes
                if (leftToRight) {
                    row.addLast(node.val);
                } else {
                    row.addFirst(node.val);
                }
            }

            ans.add(new ArrayList<>(row));

            // Change direction
            leftToRight = !leftToRight;
        }

        return ans;
    }


    // =========================================================
    // Main
    // =========================================================

    public static void main(String[] args) {

        /*
                    3
                   / \
                  9   20
                     /  \
                    15   7

            Expected Zigzag:

            [3]
            [20, 9]
            [15, 7]
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        // V1
        System.out.println("V1 - DFS:");
        System.out.println(zigzagV1(root));


        // V2
        System.out.println("V2 - Queue + Deque:");
        System.out.println(zigzagV2(root));
    }
}