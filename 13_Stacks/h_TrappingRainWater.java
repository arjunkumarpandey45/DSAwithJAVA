import java.util.Stack;

public class h_TrappingRainWater {

    public int trap(int[] height) {

        int n = height.length;
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && height[i] > height[st.peek()]) {

                // Bottom of the container
                int bottom = st.pop();

                // No left boundary exists
                if (st.isEmpty()) {
                    break;
                }

                // Left boundary
                int left = st.peek();

                // Width of trapped water
                int width = i - left - 1;

                // Height of trapped water
                int h = Math.min(height[left], height[i]) - height[bottom];

                // Water trapped
                ans += width * h;
            }

            st.push(i);
        }

        return ans;
    }
}