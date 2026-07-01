import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s_OverlappIntervals {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
       ;

    System.out.println(Arrays.deepToString (OverlappIntervals(arr)));
    }

    public static int[][] OverlappIntervals(int[][] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = arr[0];
        ans.add(newInterval);
        for (int[] interval : arr) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval=interval;
                ans.add(newInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
