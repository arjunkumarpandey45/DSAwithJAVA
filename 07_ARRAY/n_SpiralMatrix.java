import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

        System.out.println(spiralMAtrix(matrix));
        ;

    }

    public static List<Integer> spiralMAtrix(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int right = matrix[0].length - 1;
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;
    }
}
