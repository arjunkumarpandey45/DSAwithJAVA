public class e_SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 2;
        System.out.println(search(arr, target));

    }

    public static boolean search(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target&&arr[mid]>=target){
                    high=mid-1;
                   
                }else{
                     low=mid+1;
                }
            }else{
                if(arr[mid]<=target&&arr[high]>=target){
                      low=mid+1;
                }else{
                     high=mid-1;
                }
            }
        }
        return false;
    }
}
