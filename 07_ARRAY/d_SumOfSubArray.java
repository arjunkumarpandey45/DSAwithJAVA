
import java.util.HashMap;
import java.util.Map;

public class d_SumOfSubArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        
       System.out.println( getSubArr(arr, 6));
    }

    public static int getSubArr(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for (int num : arr) {
            prefixSum += arr[num-1];
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
