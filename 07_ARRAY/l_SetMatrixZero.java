import java.util.Arrays;

public class l_SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 0 }, { 1, 9, 1, 3 }, { 1, 1, 1, 3 } };
        System.out.println(Arrays.deepToString(matrix));
        // setMatrixZeroV1(matrix);
        setMatrixZeroV2(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setMatrixZeroV1(int[][] matrix) {
        boolean[][] aux = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    aux[i][j] = true;
                }
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int k = 0;
                while (aux[i][j] == true && k < matrix.length) {
                    matrix[k][j] = 0;
                    k++;
                }
                int l = 0;
                while (aux[i][j] == true && l < matrix[0].length) {
                    matrix[i][l] = 0;
                    l++;
                }
            }
        }
    }

    public static void setMatrixZeroV2(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstRow = true;
                    if (j == 0)
                        firstCol = true;
matrix[i][0]=0;
matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }

            }
        }
        if (firstCol) {

            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }

    }
}
