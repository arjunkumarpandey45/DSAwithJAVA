import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;



class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class c_BFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
         System.out.println(breadthWiseTraversal(root));//via queue 
         System.out.println(levelOrder(root)); //via recursion
    }

    public static List<List<Integer>> breadthWiseTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> row=new ArrayList<>();
            int len=q.size();
            for (int i = 0; i < len; i++) {
                if(q.peek().left!=null)q.offer(q.peek().left);
                if(q.peek().right!=null)q.offer(q.peek().right);
                row.add(q.poll().data);
            }
            ans.add(row);
        }
        return ans;

    }
     public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode nLevel(TreeNode root, int h, List<Integer> row) {
        if (root == null) {
            return null;
        }
        if (h == 1) {
            row.add(root.data);
        }
      nLevel(root.left, h - 1, row);
      nLevel(root.right, h - 1, row);
      return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        int h = height(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= h; i++) {
            List<Integer> row = new ArrayList<>();
            nLevel(root, i, row);
            ans.add(row);
        }
        return ans;

    }
}