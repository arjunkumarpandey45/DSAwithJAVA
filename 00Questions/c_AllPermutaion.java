import java.util.ArrayList;


public class c_AllPermutaion {
    public static void main(String[] args) {
        int[] ar = {1, 2};
        boolean[] freq = new boolean[ar.length];
       permutationApproach1(ar,  new ArrayList<>(), freq);
        permutationApproach2(ar, 0);
    }

    //                           []
//                 /-----------|-----------\
//                /            |            \
//              [1]           [2]          [3]
//            /     \        /    \       /    \
//         [1,2]   [1,3]  [2,1] [2,3] [3,1] [3,2]
//           |        |      |      |     |      |
//      [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1]
    public static void permutationApproach1(int[] arr, ArrayList<Integer> ds, boolean[] freq) {
        if (ds.size() == arr.length) {
            for (Integer i : ds) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }
        //without freq u get all permutation
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(arr[i]);
                permutationApproach1(arr, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }

    }

//                                        [1,2,3]
//                                     idx=0
//                    /------------------|------------------\
//                   /                   |                   \
//            swap(0,0)            swap(1,0)           swap(2,0)
//              [1,2,3]              [2,1,3]             [3,2,1]
//               idx=1                 idx=1                idx=1
//             /-------\             /-------\            /-------\
//            /         \           /         \          /         \
//     swap(1,1)   swap(2,1) swap(1,1) swap(2,1) swap(1,1) swap(2,1)
//       [1,2,3]    [1,3,2]   [2,1,3]   [2,3,1]   [3,2,1]   [3,1,2]
//         idx=2      idx=2      idx=2      idx=2      idx=2      idx=2
//            |           |          |          |          |          |
//      swap(2,2)   swap(2,2) swap(2,2) swap(2,2) swap(2,2) swap(2,2)
//            |           |          |          |          |          |
//        [1,2,3]    [1,3,2]   [2,1,3]   [2,3,1]   [3,2,1]   [3,1,2]
//            ✅           ✅         ✅         ✅         ✅         ✅
//          print       print     print     print     print     print
    public static void permutationApproach2(int[] arr, int idx) {
        if (idx == arr.length) {
            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }
        for (int i = idx; i < arr.length; i++) {

            swap(i, idx, arr);
            permutationApproach2(arr, idx + 1);

             swap(i, idx, arr);

        }

    }

    public static void swap(int l, int r, int[] arr) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

}
