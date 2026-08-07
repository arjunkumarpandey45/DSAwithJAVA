
import java.util.Stack;

public class p_LargestRectangleInHistogram{
public static void main(String[] args) {

        

        int[] heights = {2, 1, 5, 6, 2, 3};

        int ans = largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area = " + ans);
    }
    public static  int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                int currentIndex = stack.pop();
                int nextSmaller = i;
                int previousSmaller = stack.isEmpty() ? -1 : stack.peek();

                int width = nextSmaller - previousSmaller - 1;
                int area = heights[currentIndex] * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {

            int currentIndex = stack.pop();
            int nextSmaller = n;
            int previousSmaller = stack.isEmpty() ? -1 : stack.peek();

            int width = nextSmaller - previousSmaller - 1;
            int area = heights[currentIndex] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}