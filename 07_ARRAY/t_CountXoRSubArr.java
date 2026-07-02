import java.util.HashMap;
import java.util.Map;

public class t_CountXoRSubArr {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int target = 6;
        System.out.println(countXORSubArrOptimal(arr, target));
        ;
    }

    public static int countXORSubArrBrute(int[] arr, int target) {
        int c = 0;

        for (int start = 0; start < arr.length; start++) {
            int xor = 0;
            for (int end = start; end < arr.length; end++) {

                xor = xor ^ arr[end];

                if (xor == target) {
                    c++;
                }

            }
        }
        return c;
    }

    public static int countXORSubArrOptimal(int[] arr, int target) {
        int c = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixXOR = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixXOR = prefixXOR ^ arr[i];
            if (map.containsKey(prefixXOR ^ target)) {
                c += map.get(prefixXOR ^ target);
            }

            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);

        }

        return c;
    }

}
