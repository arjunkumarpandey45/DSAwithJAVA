package zDailyQuiz;
public class DQ19_CreateGridWithExactlyOnePath {

    public static String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    row.append('.');
                } else {
                    row.append('#');
                }
            }

            ans[i] = row.toString();
        }

        return ans;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        String[] result = createGrid(m, n);

        System.out.println("Grid:");
        for (String row : result) {
            System.out.println(row);
        }
    }
}