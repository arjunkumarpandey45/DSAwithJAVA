import java.util.Arrays;

public class s_Maximum1s {
    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };
        System.out.println(Arrays.toString(rowAndMaximumOnes(arr)));
    }

    public static int[] rowAndMaximumOnes(int[][] mat) {

        // System.out.println(high);
        int onesCount = 0;
        int index = 0;
        for (int i = 0; i < mat.length; i++) {
            int high = mat[0].length - 1;
            int currentOneCount = 0;
            int low = 0;
            while (low <= high) {

                int mid = low + (high - low) / 2;
                if (mat[i][mid] == 1) {

                  currentOneCount = mat[0].length - mid;
                 
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
 
            }
 
            if (currentOneCount > onesCount) {
                onesCount = currentOneCount;
              
                index = i;
                System.out.println(onesCount+""+i);
                System.out.println(i);
            }
        }
        return new int[] { index, onesCount };
    }
}
