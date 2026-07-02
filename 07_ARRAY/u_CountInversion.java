import java.util.ArrayList;

public class u_CountInversion {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1 };
        System.out.println(countInversion(arr));
        ;
    }

    public static int countInversion(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, high, mid);
        return count;
    }

    public static int merge(int[] arr, int low, int high, int mid) {
        int count = 0;
        ArrayList<Integer> ds = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ds.add(arr[left]);
                left++;
            } else {
                ds.add(arr[right]);
                count += (mid - left + 1);
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
        return count;
    }
}
