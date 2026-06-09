
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a_TargetSubsequences {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        Arrays.sort(arr);
        int target = 2;
        List<Integer> ds = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int sum = 0;
//        getAllSequences(0, arr, ds, n, target, sum);
//        getAllUniqueCombinationOfTarget(0, arr, ds, target);
        printSubsequence(arr,0,list,sum,target);

    }

    public static void getAllSequences(int ind, int[] arr, List<Integer> ds, int n, int target, int sum) {
        if (ind == n) {
            if (sum == target) {
                System.out.print("[ ");
                for (Integer integer : ds) {
                    System.out.print(integer + " ");
                }
                System.out.println(" ]");
                System.out.println();
            }
            return;
        }
        ds.add(arr[ind]);
        getAllSequences(ind + 1, arr, ds, n, target, sum + arr[ind]);
        ds.removeLast();
        getAllSequences(ind + 1, arr, ds, n, target, sum);
    }

    //
    public static void getAllUniqueCombinationOfTarget(int ind, int[] arr, List<Integer> ds, int target) {
        if (target == 0) {
            System.out.print("[ ");
            for (Integer it : ds) {

                System.out.print(it + " ");
            };
            System.out.print(" ]");
            System.out.println();
            return;

        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            ds.add(arr[i]);
            getAllUniqueCombinationOfTarget(i + 1, arr, ds, target - arr[i]);
            ds.remove(ds.size() - 1);

        }
    }

    public static void printSubsequence(int[] arr, int idx, ArrayList<Integer> list, int sum,int target){
        if(idx==arr.length){

            if (sum == target) {
                System.out.println();
                for(Object seq:list){

                    System.out.print(seq+" ");
                }

            }

            return;
        }


        list.add(arr[idx]);
        printSubsequence(arr,idx+1,list,sum+arr[idx],target);
        list.remove(list.size()-1);
       printSubsequence(arr,idx+1,list,sum,target);

    }
}
