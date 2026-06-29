import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class g_MajorityElement {
    public static void main(String[] args) {
        int[] arr = { 1 };
        // System.out.println(majorityEle(arr));
        System.out.println(majorityEleIIV2(arr));
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

    // MAjority Element II
    public static List<Integer> majorityEleII(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > arr.length / 3) {
                ans.add(i.getKey());
            }
        }
        return ans;
    }

    public static List<Integer> majorityEleIIV2(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (count1 == 0 && arr[i] != ele2) {
                ele1 = arr[i];
                count1 = 1;
            } else if (count2 == 0 && arr[i] != ele1) {
                count2 = 1;
                ele2 = arr[i];
            } else if (ele1 == arr[i]) {
                count1++;
            } else if (ele2 == arr[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        System.out.println(ele1 + " " + ele2);
        count1=0;
        count2=0;
        for (int i = 0; i < arr.length; i++) {
            if (ele1 == arr[i])
                count1++;
            if (ele2 == arr[i])
                count2++;

        }

        if (count1>=arr.length/3 +1)ans.add(ele1);
        if(count2>=arr.length/3 +1) ans.add(ele2);
        return ans;
    }
}
