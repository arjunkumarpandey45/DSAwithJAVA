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

public class o_MaximumWidthOfBinaryTree {

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            int first = q.peek().index;
            int last = first;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                TreeNode node = curr.node;
                int index = curr.index;

                last = index;

                // Left child
                if (node.left != null) {
                    q.offer(
                        new Pair(node.left, 2 * index + 1)
                    );
                }

                // Right child
                if (node.right != null) {
                    q.offer(
                        new Pair(node.right, 2 * index + 2)
                    );
                }
            }

            int width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 3     2
                /       \
               5         9

        Index:

                    1(0)
                  /     \
              3(1)      2(2)
              /           \
           5(3)            9(6)

        Level 2 width = 6 - 3 + 1 = 4
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        int result = widthOfBinaryTree(root);

        System.out.println("Maximum Width: " + result);
    }
}