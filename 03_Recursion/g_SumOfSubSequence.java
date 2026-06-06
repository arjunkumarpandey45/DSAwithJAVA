
import java.util.ArrayList;
import java.util.List;

public class g_SumOfSubSequence {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3 };
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        int n = arr.length;
        int target = 4;
        // sumOfSubSequences(0, ds, sum, n, arr);
        // targetSumSubSequence(0, target, ds, sum, n, arr);
        // exactTargetSumSubSequence(0, target, ds, sum, n, arr);
        System.out.println(exactCountOfSumSubSequence(0, target, sum, n, arr));
    }

    public static void sumOfSubSequences(int ind, List<Integer> ds, int sum, int n, int[] arr) {

        if (ind == n) {
            for (Integer ds2 : ds) {
                System.out.print(ds2 + " ");

            }
            System.out.println();
            System.out.print("Sum of Above SubSequence is : ");
            System.out.print(sum);
            if (ds.isEmpty()) {
                System.out.print("{}");
            }
            System.out.println();
            return;
        }

        ds.add(arr[ind]);
        sumOfSubSequences(ind + 1, ds, sum + arr[ind], n, arr);
        ds.remove(ds.size() - 1);
        sumOfSubSequences(ind + 1, ds, sum, n, arr);
    }

    public static void targetSumSubSequence(int ind,
            int target,
            List<Integer> ds,
            int sum,
            int n,
            int[] arr) {

        // Base Case
        if (ind == n) {

            if (sum == target) {

                System.out.print("Subsequence is : ");

                if (ds.isEmpty()) {
                    System.out.print("{}");
                } else {
                    for (Integer ele : ds) {
                        System.out.print(ele + " ");
                    }
                }

                System.out.println();
            }

            return;
        }

        // Pick
        ds.add(arr[ind]);

        targetSumSubSequence(ind + 1,
                target,
                ds,
                sum + arr[ind],
                n,
                arr);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Not Pick
        targetSumSubSequence(ind + 1,
                target,
                ds,
                sum,
                n,
                arr);
    }

    public static boolean exactTargetSumSubSequence(int ind,
            int target,
            List<Integer> ds,
            int sum,
            int n,
            int[] arr) {

        // Base Case
        if (ind == n) {

            if (sum == target) {

                System.out.print("Subsequence is : ");

                if (ds.isEmpty()) {
                    System.out.print("{}");
                } else {
                    for (Integer ele : ds) {
                        System.out.print(ele + " ");
                    }
                }

                System.out.println();
                return true;
            }

            return false;
        }

        // Pick
        ds.add(arr[ind]);

        boolean pick = exactTargetSumSubSequence(
                ind + 1,
                target,
                ds,
                sum + arr[ind],
                n,
                arr);

        // Backtrack (IMPORTANT)
        ds.remove(ds.size() - 1);

        if (pick) {
            return true;
        }

        // Not Pick
        return exactTargetSumSubSequence(
                ind + 1,
                target,
                ds,
                sum,
                n,
                arr);
    }

    public static int exactCountOfSumSubSequence(int ind,
            int target,

            int sum,
            int n,
            int[] arr) {

        // Base Case
        if (ind == n) {

            if (sum == target) {

                return 1;
            }

            return 0;
        }

        int l = exactCountOfSumSubSequence(ind + 1, target, sum + arr[ind], n, arr);

        // Not Pick
        int r = exactCountOfSumSubSequence(ind + 1, target, sum, n, arr);
        return l + r;
    }

}
