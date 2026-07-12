import java.util.Arrays;

public class c_FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange(arr, 8)));
        ;

    }

    public static int[] searchRange(int[] arr, int target) {
        int ans[] = new int[2];
        ans[0] = firstOccurance(arr, target);
          if (arr[0] == -1) {
        return new int[]{-1, -1};
    }

        ans[1] = lastOccurance(arr, target);

        return ans;
    }

    public static int firstOccurance(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
           if (arr[mid] >= target) {
                if (arr[mid] == target) {
                    ans = mid;

                    
                }
           high=mid-1;
            }  else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurance(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(arr[mid]);
            if (arr[mid] <= target) {
                if (arr[mid] == target) {
                    ans = mid;

                    
                }
            low = mid + 1;
            } else {
                high = mid - 1;

            }
        }
        return ans;
    }
}
