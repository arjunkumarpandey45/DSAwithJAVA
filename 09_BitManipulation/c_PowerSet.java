import java.util.ArrayList;
import java.util.List;

public class c_PowerSet {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(powerSet(arr));
    }

    public static List<List<Integer>> powerSet(int[] arr) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << arr.length); i++) {
            List<Integer> r = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    r.add(arr[j]);
                }
            }
            ans.add(r);
        }
        return ans;
    }

}
