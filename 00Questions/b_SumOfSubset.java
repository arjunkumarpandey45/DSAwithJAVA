import java.util.ArrayList;
import java.util.List;

public class b_SumOfSubset {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int sum = 0;

//sumOfSubset(arr,sum,0,new ArrayList<>());
        uniqueSubset(arr, 0, new ArrayList<>());
    }
//                                   []
//                              sum = 0
//                           /            \
//                        take 1         skip 1
//                       [1]              []
//                     sum=1            sum=0
//                   /      \          /      \
//              take 2    skip 2   take 2   skip 2
//             [1,2]       [1]      [2]       []
//             sum=3      sum=1    sum=2    sum=0
//             /   \      /   \    /   \    /   \
//          +3   no3   +3   no3  +3  no3  +3  no3
//        [1,2,3][1,2][1,3][1][2,3][2][3][]
//         sum=6 sum=3 sum=4 sum=1 sum=5 sum=2 sum=3 sum=0
    public static void sumOfSubset(int[] arr, int sum, int idx, ArrayList<Integer> ds) {
        if (idx == arr.length) {
            for (Integer i : ds) {
                System.out.print(i + " ");

            }
            System.out.println(" And Sum is " + sum);
            return;
        }
        ds.add(arr[idx]);
        sumOfSubset(arr, sum + arr[idx], idx + 1, ds);
        ds.remove(ds.size() - 1);
        sumOfSubset(arr, sum, idx + 1, ds);

    }
//                           []
//                     idx = 0
//                  /      |      \
//                 1       2       3
//               [1]     [2]     [3]
//              /   \       \       \
//             2     3       3       x
//          [1,2] [1,3]   [2,3]
//             |      |      |
//             3      x      x
//         [1,2,3]
    public static void uniqueSubset(int[] arr, int idx, ArrayList<Integer> ds) {

        for (Integer i : ds) {
            System.out.print(i);

        }
        System.out.println();

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            uniqueSubset(arr, i + 1, ds);
            ds.remove(ds.size() - 1);
        }


    }

}
