import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class l_TopAndBottomView {

    // ================= TOP VIEW =================

    static List<Integer> topView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Root has horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            // Top View:
            // Store only the FIRST node at this HD
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Left -> HD - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right -> HD + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }


    // ================= BOTTOM VIEW =================

    static List<Integer> bottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Root has horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            TreeNode node = current.node;
            int hd = current.hd;

            // Bottom View:
            // Replace the previous node at this HD
            map.put(hd, node.data);

            // Left -> HD - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right -> HD + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        ans.addAll(map.values());

        return ans;
    }


    // ================= MAIN =================

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \     \
             4   5     6
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);


        // Top View
        List<Integer> top = topView(root);

        System.out.println("Top View: " + top);


        // Bottom View
        List<Integer> bottom = bottomView(root);

        System.out.println("Bottom View: " + bottom);
    }
}