import java.util.*;

public class e_nQueen{

    public static boolean isSafe(String[][] board,
                                 int row,
                                 int col,
                                 int n) {

        // upper column
        for (int i = row - 1; i >= 0; i--) {
            if ("Q".equals(board[i][col])) {
                return false;
            }
        }

        // upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if ("Q".equals(board[i][j])) {
                return false;
            }
        }

        // upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if ("Q".equals(board[i][j])) {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(int n,
                               List<List<String>> ans,
                               String[][] board,
                               int row) {

        // base case
        if (row == n) {

            List<String> temp =
                    new ArrayList<>();

            for (int i = 0; i < n; i++) {

                StringBuilder sb =
                        new StringBuilder();

                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }

                temp.add(sb.toString());
            }

            ans.add(temp);
            return;
        }

        // try every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board,
                    row,
                    col,
                    n)) {

                // place queen
                board[row][col] = "Q";

                // recursive call
                nQueens(n,
                        ans,
                        board,
                        row + 1);

                // backtracking
                board[row][col] = ".";
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans =
                new ArrayList<>();

        String[][] board =
                new String[n][n];

        // initialize board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }

        nQueens(n,
                ans,
                board,
                0);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<List<String>> result =
                solveNQueens(n);

        // print answer
        for (List<String> solution : result) {

            for (String row : solution) {
                System.out.println(row);
            }

            System.out.println();
        }

        sc.close();
    }
}