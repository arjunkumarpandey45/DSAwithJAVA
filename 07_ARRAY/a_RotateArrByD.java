
public class a_RotateArrByD {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        rotate3(arr, 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    // public static void rotate(int [] arr,int n){
    // n=n%arr.length;
    // System.out.println(n);
    // if(n==0){
    // return;
    // }

    // dTimeRotate(arr, n);
    // rotate(arr, n-1);
    // }
    // public static void dTimeRotate(int []arr,int n) {
    // int temp=arr[arr.length-1];
    // for (int i =arr.length-1; i >0; i--) {
    // arr[i]=arr[i-1];

    // }
    // arr[0]=temp;
    // }
    // ------------------------------------------------------------------------------------
    // public static void rotate2(int[] arr, int k) {
    // k = k % arr.length;
    // if(k==0){
    // return;
    // }

    // int[] temp = new int[k];
    // for (int i = 0; i <k; i++) {
    // temp[i] = arr[arr.length-k+i];
    // }
    // // for (int i : temp) {
    // // System.out.println(i);
    // // }
    // for (int j = 0; j <k; j++) {
    // for (int i = arr.length - 1; i >0; i--) {

    // arr[i] = arr[i-1 ];
    // }
    // }
    // for (int i = 0; i < temp.length; i++) {
    // arr[i]=temp[i];
    // }
    // }
    // -------------------------------------------------------------------------
    public static void rotate3(int[] arr, int k) {
        k = k % arr.length;
        // if(k==0){
        // return;
        // }
        // Left Rotate
        rverse(arr, 0, arr.length - 1);
        rverse(arr, 0, k - 1);
        rverse(arr, k, arr.length - 1);
        // Right Rotate

        // rverse(arr, 0, k - 1);
        // rverse(arr, k, arr.length - 1);
        // rverse(arr, 0, arr.length - 1);
    }

    public static void rverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
