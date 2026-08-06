import java.util.*;

public class o_Asteroid {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                st.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();

                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                st.pop();
            } else if (st.isEmpty() || st.peek() < 0) {
                st.push(asteroids[i]);
            }
            }

            
        }
        int ans[] = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] testCases = {
                { 5, 10, -5 },
                { 8, -8 },
                { 10, 2, -5 },
                { 3, 5, -6, 2, -1, 4 },
                { -2, -1, 1, 2 },
                { 1, -2, 10, -5 },
                { -4, 6 },
                { 1, 2, 3, -10 },
                { 10, -2, -5 },
                { 5, -3, -3, 6 }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input : " + Arrays.toString(testCases[i]));
            System.out.println("Output: " + Arrays.toString(asteroidCollision(testCases[i])));
            System.out.println();
        }
    }
}