import java.util.ArrayList;
import java.util.Collections;

public class y_LeadersInArray {
    public static void main(String[] args) {

        int[] arr = { 5,1};
       System.out.println( leaders(arr));;
    }

    public static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int current = arr[arr.length-1];
       
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i ] >= current) {
                ans.addFirst(arr[i]);
                current=arr[i];
            }
        }
           

        return ans;

    }
}
