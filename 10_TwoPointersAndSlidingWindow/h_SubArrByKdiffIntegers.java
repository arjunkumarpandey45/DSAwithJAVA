import java.util.HashMap;
import java.util.Map;

public class h_SubArrByKdiffIntegers {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(subarraysWithKDistinct(arr, k));
    }
public static int subarraysWithKDistinct(int []arr ,int k){
    return atMost(arr, k)-atMost(arr, k-1);
}
    public static int atMost(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if (k<0) {
            return 0;
        }
        int count = 0;
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while(map.size()>k){
              map.put(arr[l], map.get(arr[l] )-1);
                 if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                 }
                 l++;
            }
            count=count+i-l+1;
        }
        return count;
    }
}
