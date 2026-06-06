
import java.util.ArrayList;
import java.util.List;

public class f_SubSequence {
    public static void main(String[] args) {
        System.out.println("--Subsequence--");
        int[] arr = { 1, 2, 3 };
        List<Integer> ds = new ArrayList<>();
        int n = arr.length;
        
        subsequence(0, ds, n, arr);
    }
//                               []
//                         ind=0 (1)
//                        /          \
//                 PICK 1            NOT PICK 1
//                   [1]                  []
//                ind=1 (2)          ind=1 (2)
//                /       \           /        \
//          PICK 2       SKIP 2   PICK 2      SKIP 2
//          [1,2]          [1]      [2]          []
//        ind=2(3)      ind=2(3) ind=2(3)    ind=2(3)
//         /    \         /   \      /   \       /   \
//  PICK3  SKIP3 PICK3 SKIP3 PICK3 SKIP3 PICK3 SKIP3
// [1,2,3]  [1,2] [1,3] [1]   [2,3]  [2]  [3]  {}

// “There are 2^n subsequences and printing each can take O(n), so TC = O(n * 2^n) and recursion stack takes O(n) space.”
    public static void subsequence(int ind, List<Integer> ds, int n, int[] arr) {
        if (ind == n) {
            for (Integer ds2 : ds) {
                System.out.print(ds2 + " ");

            }

            if (ds.isEmpty()) {
                System.out.print("{}");
            }
            System.out.println();
            return;
        }

        ds.add(arr[ind]);
        subsequence(ind + 1, ds, n, arr);
        ds.remove(ds.size() - 1);
        subsequence(ind + 1, ds, n, arr);

    }
}
