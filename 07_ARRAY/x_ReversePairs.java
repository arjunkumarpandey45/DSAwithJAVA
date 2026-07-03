import java.util.ArrayList;

public class x_ReversePairs {

    public static void main(String[] args) {
        int[] arr = { 2,4,3,5,1};
        int count = reversePairs(arr);
        System.out.println(count);
    }

    public static int reversePairs(int[] nums) {
            return      mergeSort(nums, 0, nums.length - 1);
       
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
               
            }
             count += (right - (mid + 1));
        }

        return count;

    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;

       
        count+= mergeSort(arr, low, mid);
       count+= mergeSort(arr, mid + 1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, high, mid);
        return count;
    }

    public static void merge(int[] arr, int low, int high, int mid) {
        ArrayList<Integer> ds = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ds.add(arr[left]);
                left++;
            } else {
                ds.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {

            ds.add(arr[left]);
            left++;

        }
        while (right <= high) {
            ds.add(arr[right]);
            right++;

        }
        for (int i = low; i <= high; i++) {
            arr[i] = ds.get(i - low);
        }
    }
}
