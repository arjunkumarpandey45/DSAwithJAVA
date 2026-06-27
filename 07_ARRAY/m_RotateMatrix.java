import java.util.Arrays;

public class m_RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

        rotateMatrixV2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotateMatrix(int[][] matrix) {
        int[][] matrixv2 = new int[matrix.length][matrix[0].length];
        int l = 0;

        for (int i = matrix[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {

                matrixv2[j][i] = matrix[l][j];

            }
            l++;
            ;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrixv2[i][j];
            }
        }
    }

    public static void rotateMatrixV2(int[][] matrix) {

        // Step 1: Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse every row
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
   