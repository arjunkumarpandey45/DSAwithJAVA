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

public class q_AllNodeAtDistK {

    public static void makeParent(
        TreeNode root,
        TreeNode par,
        Map<TreeNode, TreeNode> parent
    ) {
        if (root == null) {
            return;
        }

        parent.put(root, par);

        makeParent(root.left, root, parent);
        makeParent(root.right, root, parent);
    }

    public static List<Integer> distanceK(
        TreeNode root,
        TreeNode target,
        int k
    ) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();

        makeParent(root, null, parent);

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k) {

                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Left child
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    q.add(node.left);
                    visited.add(node.left);
                }

                // Right child
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    q.add(node.right);
                    visited.add(node.right);
                }

                // Parent
                TreeNode par = parent.get(node);

                if (par != null &&
                    !visited.contains(par)) {

                    q.add(par);
                    visited.add(par);
                }
            }

            distance++;
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                  3
                /   \
               5     1
              / \   / \
             6   2 0   8
                / \
               7   4

             */
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode target = root.left;

        int k = 2;

        List<Integer> result = distanceK(root, target, k);

        System.out.println("Nodes at distance " + k + ": " + result);
    }
}