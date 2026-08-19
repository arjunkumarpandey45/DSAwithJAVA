import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class k_PathSum {

    // =========================================================
    // PATH SUM I
    // Question: Kya root-to-leaf path ka sum target ke equal hai?
    // =========================================================

    public static boolean pathSum1(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        targetSum -= root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        boolean left = pathSum1(root.left, targetSum);
        boolean right = pathSum1(root.right, targetSum);

        return left || right;
    }


    // =========================================================
    // PATH SUM II
    // Question: Saare root-to-leaf paths return karo
    // jinka sum target ke equal hai.
    // =========================================================

    public static void pathSum2Helper(
            TreeNode root,
            int targetSum,
            List<Integer> path,
            List<List<Integer>> ans) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        // Leaf node
        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }

            path.remove(path.size() - 1);
            return;
        }

        pathSum2Helper(root.left, targetSum, path, ans);
        pathSum2Helper(root.right, targetSum, path, ans);

        // Backtracking
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> pathSum2(
            TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        pathSum2Helper(root, targetSum, path, ans);

        return ans;
    }


    // =========================================================
    // PATH SUM III - BRUTE FORCE
    // =========================================================

    // Current root se start hone wale paths count karega
    public static int noOfPaths(TreeNode root, long targetSum) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        if (targetSum == root.val) {
            count++;
        }

        return count
                + noOfPaths(root.left, targetSum - root.val)
                + noOfPaths(root.right, targetSum - root.val);
    }


    // Har node ko starting point maanega
    public static int pathSum3(TreeNode root, long targetSum) {

        if (root == null) {
            return 0;
        }

        int count = noOfPaths(root, targetSum);

        count += pathSum3(root.left, targetSum);
        count += pathSum3(root.right, targetSum);

        return count;
    }


    // =========================================================
    // PATH SUM III - OPTIMIZED
    // Prefix Sum + HashMap
    // Time: O(N)
    // Space: O(N)
    // =========================================================

    public static int prefixSumHelper(
            TreeNode root,
            long currentSum,
            int targetSum,
            HashMap<Long, Integer> map) {

        if (root == null) {
            return 0;
        }

        // Current prefix sum
        currentSum += root.val;

        // How many previous prefix sums can form target?
        long requiredSum = currentSum - targetSum;

        int count = map.getOrDefault(requiredSum, 0);

        // Store current prefix sum
        map.put(
                currentSum,
                map.getOrDefault(currentSum, 0) + 1
        );

        // Explore left and right
        count += prefixSumHelper(
                root.left,
                currentSum,
                targetSum,
                map
        );

        count += prefixSumHelper(
                root.right,
                currentSum,
                targetSum,
                map
        );

        // Backtracking
        map.put(
                currentSum,
                map.get(currentSum) - 1
        );

        return count;
    }

    public static int pathSum3Optimized(
            TreeNode root,
            int targetSum) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Empty path ka prefix sum = 0
        map.put(0L, 1);

        return prefixSumHelper(
                root,
                0,
                targetSum,
                map
        );
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        /*
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        int target = 22;


        // =====================================================
        // PATH SUM I
        // =====================================================

        System.out.println("Path Sum I:");
        System.out.println(pathSum1(root, target));


        // =====================================================
        // PATH SUM II
        // =====================================================

        System.out.println("\nPath Sum II:");
        System.out.println(pathSum2(root, target));


        // =====================================================
        // PATH SUM III - BRUTE FORCE
        // =====================================================

        System.out.println("\nPath Sum III - Brute Force:");
        System.out.println(pathSum3(root, target));


        // =====================================================
        // PATH SUM III - OPTIMIZED
        // =====================================================

        System.out.println("\nPath Sum III - Optimized:");
        System.out.println(pathSum3Optimized(root, target));
    }
}