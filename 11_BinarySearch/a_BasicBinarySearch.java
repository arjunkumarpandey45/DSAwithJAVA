public class a_BasicBinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 500, 3150, 1141 };
        int target = 1141;
        // System.out.println("Index is " + binarySearch(arr, target));
        System.out.println(binarySearchViaRecursion(arr, target));
    }

    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static int binarySearchViaRecursion(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        return helper(arr, low, high, target);
    }

    public static int helper(int arr[], int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return helper(arr, mid + 1, high, target);
        } else {
            return helper(arr, low, mid - 1, target);
        }

    }
}
