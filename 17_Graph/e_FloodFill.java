import java.util.*;

public class e_FloodFill {

    static void dfs(int[][] image, int sr, int sc, int color,
                    int[] delRow, int[] delCol, int sColor) {

        int n = image.length;
        int m = image[0].length;

        image[sr][sc] = color;

        for (int i = 0; i < 4; i++) {

            int r = sr + delRow[i];
            int c = sc + delCol[i];

            if (r >= 0 && r < n &&
                c >= 0 && c < m &&
                image[r][c] == sColor) {

                dfs(image, r, c, color, delRow, delCol, sColor);
            }
        }
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int sColor = image[sr][sc];

        if (sColor == color) {
            return image;
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(image, sr, sc, color, delRow, delCol, sColor);

        return image;
    }

    public static void main(String[] args) {

        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}