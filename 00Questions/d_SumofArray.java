import java.util.ArrayList;

public class d_SumofArray {
    public static void main(String[] args){
        int [] arr ={1,2,1,1};
//        sumOfArray(arr,0,0);
        SubSequence(arr,new ArrayList<>(),0);
//       if( linearSearch(arr,0,1)){
//           System.out.println("Found");
//       }else {
//           System.out.println("NOT FOUND");
//       }
    }

    public static void sumOfArray(int []arr,int idx,int sum){
        if(idx==arr.length){
            System.out.println(sum);
            return;
        }

        sumOfArray(arr,idx+1,sum+arr[idx]);
    }
    public static boolean linearSearch(int [] arr,int idx,int target){
        if(idx==arr.length){
            return false;
        }
        if(arr[idx]==target){
            return true;
        }
       return linearSearch(arr,idx+1,target);



    }
    public static void SubSequence(int [] arr, ArrayList<Integer> ds, int idx){
        if(idx==arr.length){
            for(Integer i: ds){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        ds.add(arr[idx]);
        SubSequence(arr,ds,idx+1);
        ds.remove(ds.size()-1);
        SubSequence(arr,ds,idx+1);
    }

}
