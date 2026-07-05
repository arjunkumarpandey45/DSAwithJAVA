import java.util.ArrayList;
import java.util.List;

public class o_PascalTriangle {
    public static void main(String[] args) {

        System.out.println(generate(6));
        ;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            int v = 1;
            
            List<Integer> row = new ArrayList<>();
            row.add(v);
            for (int j = 0; j <i; j++) {
                v *=( i - j);
                v /= (j + 1);
                row.add(v);
            }
            ans.add(row);
        }
        return ans;
    }

}
