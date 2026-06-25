import java.util.HashMap;
import java.util.Map;

public class g_MajorityElement {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 1, 1, 1, 1, 1, 1 };
        // System.out.println(majorityEle(arr));
        System.out.println(majorityEleV2(arr));
    }

    public static int majorityEle(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int n = (arr.length - 1) / 2;
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue() > n) {
                return num.getKey();
            }
        }

        return -1;
    }

    public static int majorityEleV2(int[] arr) {
        int i = 0;
        int ele = arr[i];
        int count = 0;
        while (i < arr.length) {
            if (ele != arr[i]) {
                count--;
            }
            if (ele == arr[i]) {
                count++;
            }
            if (count == 0) {
                ele = arr[i];
                i--;
            }
            i++;
        }
        if (count > 0) {
            return ele;
        }
        return -1;
    }

}
