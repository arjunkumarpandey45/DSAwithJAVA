public class b_ImportantBSProblem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 4, 4, 6, 8 };
        int target = 5;
        int arr2[] = { 1, 2, 4, 6, 8 };
        int target2 = 5;
        System.out.println("Lower Bound Index  is " + lowerBound(arr, target));
        System.out.println("Upper Bound Index  is " + upperBound(arr, target));
        System.out.println("Floor Value is " + floor(arr2, target2));
        System.out.println("Ciel Value is " + ciel(arr2, target2));
}
// | Problem     | Condition            | Answer milne ke baad |
// | ----------- | -------------------- | -------------------- |
// | Lower Bound | `arr[mid] >= target` | `high = mid - 1`     |
// | Upper Bound | `arr[mid] > target`  | `high = mid - 1`     |
// | Floor       | `arr[mid] <= target` | `low = mid + 1`      |
// | Ceil        | `arr[mid] >= target` | `high = mid - 1`     |
// Lower Bound = first index with value >= target
// Upper Bound = first index with value > target

// Floor = largest value <= target
// Ceil  = smallest value >= target
    public static int lowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {

                low = mid + 1;

            }
        }
        return ans;
    }

    public static int floor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;

            }
        }
        return ans;
    }

    public static int ciel(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
              high = mid - 1;
            } else {
               
                   low = mid + 1;

            }
        }
        return ans;
    }

}
