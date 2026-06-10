import java.util.ArrayList;
import java.util.List;

public class b_SumOfSubset {
    public static void main(String[] args) {
int[]arr={1,1,1}
        ;
int sum=0;

//sumOfSubset(arr,sum,0,new ArrayList<>());
uniqueSubset(arr,0,new ArrayList<>());
    }

    public static void sumOfSubset(int[] arr, int sum, int idx, ArrayList<Integer> ds) {
        if (idx == arr.length ) {
            for (Integer i : ds) {
                System.out.print(i+" ");

            }
            System.out.println(" And Sum is " + sum);
            return;
        }
     ds.add(arr[idx] );
        sumOfSubset(arr,sum+arr[idx],idx+1,ds);
        ds.remove(ds.size()-1);
        sumOfSubset(arr,sum,idx+1,ds);

    }

    public static void uniqueSubset(int[] arr, int idx, ArrayList<Integer> ds) {

            for (Integer i: ds){
                System.out.print(i);

            }
            System.out.println();

        for (int i = idx; i < arr.length ; i++) {
            if(i>idx && arr[i]==arr[i-1])continue;
            ds.add(arr[i] );
            uniqueSubset(arr,i+1,ds);
            ds.remove(ds.size()-1);
        }



    }

}
