public class g_SingleElemennt {
    public static void main(String[] args) {
        int arr[] = { 3,3,7,7,10,11,11 };
        System.out.println(sigleElement(arr));
    }

    public static int sigleElement(int arr[]) {
        int low = 1;
        int n = arr.length;
        int high = n - 2;
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
            if (mid % 2 == 1 && arr[mid] == arr[mid - 1] || mid % 2 == 0 && arr[mid] == arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }
}
