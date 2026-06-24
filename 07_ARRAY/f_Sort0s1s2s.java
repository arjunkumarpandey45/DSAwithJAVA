 import java.util.Arrays;
public class f_Sort0s1s2s {
   



    public static void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(arr));

        sortColors(arr);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(arr));
    }

}
