import java.util.*;

public class r_TimeToBurnTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode makeParent(
            TreeNode root,
            TreeNode par,
            Map<TreeNode, TreeNode> parent,
            int start,
            TreeNode[] startNode) {

        if (root == null) {
            return null;
        }

        parent.put(root, par);

        if (root.val == start) {
            startNode[0] = root;
        }

        makeParent(root.left, root, parent, start, startNode);
        makeParent(root.right, root, parent, start, startNode);

        return root;
    }

    public static int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode[] startNode = new TreeNode[1];

        makeParent(root, null, parent, start, startNode);

        int time = -1;

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(startNode[0]);
        visited.add(startNode[0]);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node.left != null &&
                    !visited.contains(node.left)) {

                    q.add(node.left);
                    visited.add(node.left);
                }

                if (node.right != null &&
                    !visited.contains(node.right)) {

                    q.add(node.right);
                    visited.add(node.right);
                }

                TreeNode par = parent.get(node);

                if (par != null &&
                    !visited.contains(par)) {

                    q.add(par);
                    visited.add(par);
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(2);

        int start = 3;

        System.out.println(amountOfTime(root, start));
    }
}