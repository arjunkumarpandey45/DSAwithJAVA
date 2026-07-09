import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class d_FruitsAndbasket {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(fruitsAndBasketOptimal(arr));
    }

    public static int fruitsAndBasket(int[] arr) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.size() > 2) {
                while (map.size() > 2) {
                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) == 0) {
                        map.remove(arr[l]);
                    }
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static int fruitsAndBasketOptimal(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int maxLen=0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if(map.size()>2){
                 map.put(arr[l], map.get(arr[l] )-1);
                 
                  
                  if (map.get(arr[l]) == 0) {
                        map.remove(arr[l]);
                    }
                 l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;

    }

}
