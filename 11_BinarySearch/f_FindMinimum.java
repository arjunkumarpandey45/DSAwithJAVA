public class f_FindMinimum {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,1 };
        System.out.println(findMin(arr));
        System.out.println(findMin2(arr));

    }

    public static int findMin(int arr[]) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] < min) {
                min = arr[low];
            }
            if (arr[mid] < min) {
                min = arr[mid];
            }

            if (arr[high] < min) {
                min = arr[high];
            }

            if (arr[low] <= arr[mid]) {
                if (arr[mid] >= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            } else {
                if (arr[mid] >= arr[high]) {
                       low = mid + 1;
                } else {
                     high = mid - 1;
                
                }

            }
        }
        return min;
    }

    public static int findMin2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            }

         
            else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }

        return min;
    }
}


