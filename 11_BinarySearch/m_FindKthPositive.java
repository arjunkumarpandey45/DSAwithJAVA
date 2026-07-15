public class m_FindKthPositive {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int k = 1;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int arr[], int k) {
              int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
System.out.println(mid);
            
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
                System.out.println(low);
            } else {
                high = mid - 1;
            }
        }

        return low + k;
    }

 
}
