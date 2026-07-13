public class h_PeakELement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 6, 1 };
        System.out.println(peakElement(arr));

    }

    public static int peakElement(int arr[]) { 
        int low=0;

        int high=arr.length-1;
        while (low<high) {
            int mid=low+(high-low)/2;
            if (arr[mid]<arr[mid+1]) {
        low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
}
