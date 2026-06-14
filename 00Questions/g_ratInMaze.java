import java.util.*;

public class g_ratInMaze {




        public static void check(int[][] maze,
                                 boolean[][] trail,
                                 int x,
                                 int y,
                                 ArrayList<String> ds,
                                 String s) {

            // destination reached
            if (x == maze.length - 1
                    && y == maze[0].length - 1) {

                ds.add(s);
                return;
            }

            // Down
            if (x + 1 < maze.length
                    && maze[x + 1][y] == 1
                    && !trail[x + 1][y]) {

                trail[x + 1][y] = true;

                check(maze,
                        trail,
                        x + 1,
                        y,
                        ds,
                        s + "D");

                // backtracking
                trail[x + 1][y] = false;
            }

            // Left
            if (y > 0
                    && maze[x][y - 1] == 1
                    && !trail[x][y - 1]) {

                trail[x][y - 1] = true;

                check(maze,
                        trail,
                        x,
                        y - 1,
                        ds,
                        s + "L");

                // backtracking
                trail[x][y - 1] = false;
            }

            // Right
            if (y + 1 < maze[0].length
                    && maze[x][y + 1] == 1
                    && !trail[x][y + 1]) {

                trail[x][y + 1] = true;

                check(maze,
                        trail,
                        x,
                        y + 1,
                        ds,
                        s + "R");

                // backtracking
                trail[x][y + 1] = false;
            }

            // Up
            if (x > 0
                    && maze[x - 1][y] == 1
                    && !trail[x - 1][y]) {

                trail[x - 1][y] = true;

                check(maze,
                        trail,
                        x - 1,
                        y,
                        ds,
                        s + "U");

                // backtracking
                trail[x - 1][y] = false;
            }
        }

        public static ArrayList<String> ratInMaze(
                int[][] maze) {

            ArrayList<String> ds =
                    new ArrayList<>();

            boolean[][] trail =
                    new boolean[maze.length]
                            [maze[0].length];

            // start blocked
            if (maze[0][0] == 0) {
                return ds;
            }

            trail[0][0] = true;

            check(maze,
                    trail,
                    0,
                    0,
                    ds,
                    "");

            return ds;
        }

        public static void main(String[] args) {

            Scanner sc =
                    new Scanner(System.in);

            System.out.print("Enter n: ");
            int n = sc.nextInt();

            int[][] maze =
                    new int[n][n];

            System.out.println(
                    "Enter maze (0 or 1):");

            for (int i = 0;
                 i < n;
                 i++) {

                for (int j = 0;
                     j < n;
                     j++) {

                    maze[i][j] =
                            sc.nextInt();
                }
            }

            ArrayList<String> ans =
                    ratInMaze(maze);

            System.out.println(ans);

            sc.close();
        }
    }

