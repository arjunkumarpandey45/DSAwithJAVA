import java.util.*;

public class i_SurroundedRegions {

    static void dfs(char[][] board, int[][] vis,
                    int[] delRow, int[] delCol,
                    int row, int col) {

        int m = board.length;
        int n = board[0].length;

        vis[row][col] = 1;

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                vis[nrow][ncol] == 0 &&
                board[nrow][ncol] == 'O') {

                dfs(board, vis, delRow, delCol, nrow, ncol);
            }
        }
    }

    static void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

      
        for (int i = 0; i < n; i++) {

            if (vis[0][i] == 0 && board[0][i] == 'O') {
                dfs(board, vis, delRow, delCol, 0, i);
            }

            if (vis[m - 1][i] == 0 && board[m - 1][i] == 'O') {
                dfs(board, vis, delRow, delCol, m - 1, i);
            }
        }

      
        for (int i = 0; i < m; i++) {

            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(board, vis, delRow, delCol, i, 0);
            }

            if (vis[i][n - 1] == 0 && board[i][n - 1] == 'O') {
                dfs(board, vis, delRow, delCol, i, n - 1);
            }
        }

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);

      
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}