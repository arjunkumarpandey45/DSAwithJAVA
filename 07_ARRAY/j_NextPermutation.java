import java.util.Arrays;

public class j_NextPermutation {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1 };
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] arr) {
        int pivot = -1;
        for (int i = arr.length - 2; i >= 0; i--) {

            if (arr[i] < arr[i + 1]) {

                pivot = i;
                System.out.println(pivot);
                break;
            }

        }
        int j = arr.length - 1;

        while (arr[j] <= arr[pivot]) {
            j--;
        }
        System.out.println(pivot);
        if (pivot == -1) {
            reverse(arr, 0, arr.length - 1);
        } else {
            swap(arr, pivot, j);
            reverse(arr, pivot + 1, arr.length - 1);
        }

    }

    public static void swap(int[] arr, int pivot, int rightMostLow) {
        int temp = arr[pivot];
        arr[pivot] = arr[rightMostLow];
        arr[rightMostLow] = temp;
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;

        }
    }
}
