
import java.util.*;

public class d_MeregSort {
    public static void main(String[] args) {
        int[] arr = { 1,3,2,6,4};

        mergeSort(arr, 0, arr.length - 1);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
//                  ms(0, 4)  [mid = 2]
//                      /          \
//          ms(0, 2) [mid = 1]      ms(3, 4) [mid = 3]
//           /         \              /         \
// ms(0, 1) [mid=0]   ms(2, 2)     ms(3, 3)    ms(4, 4)
//   /        \         (Base Case) (Base Case) (Base Case)
// ms(0,0)   ms(1,1)
// (Base)    (Base)
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high, mid);
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
