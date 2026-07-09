import java.rmi.dgc.Lease;
import java.util.ArrayList;
import java.util.List;

public class c_MaxConsecutivesOnesIII {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(maxOnesBetter(arr, k));
    }

    public static int maxOnesBrute(int[] arr, int k) {

        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int kCount = k;
                List<Integer> row = new ArrayList<>();
                for (int j2 = i; j2 <= j; j2++) {

                    if (arr[j2] == 0 && kCount != 0) {
                        kCount--;
                    } else if (kCount == 0 && arr[j2] == 0) {
                        // maxCount = Math.max(maxCount, row.size());
                        break;
                    }
                    row.add(arr[j2]);
                    maxCount = Math.max(maxCount, row.size());
                    System.out.println(row);

                }
            }

        }
        return maxCount;
    }

    public static int maxOnesBetter(int[] arr, int k) {
       int maxCount = 0;
    int left = 0;
    int zeroCount = 0;

    for (int right = 0; right < arr.length; right++) {

        if (arr[right] == 0) {
            zeroCount++;
        }

        while (zeroCount > k) {
            if (arr[left] == 0) {
                zeroCount--;
            }
            left++;
        }

        maxCount = Math.max(maxCount, right - left + 1);
    }

    return maxCount;
    }

}