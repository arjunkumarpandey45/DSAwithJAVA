public class z_PivotIndex {
    public static void main(String[] args) {
        int[] arr = { 1,7,3,6,5,6 };
        int p = pivot(arr);
        System.out.println(p);
    }

    public static int pivot(int[] arr) {
        int totalSum = 0;
        int p = -1;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum - arr[i];
            if (leftSum == totalSum) {
                p = i;

            }
             leftSum+=arr[i];
            
            
           
        }
        return p;
    }
}
