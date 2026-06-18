public class c_InsertionSort {
    public static void main(String[] args) {
        int []arr={10,2,3,4,5,6,0};
        for (int i = 0; i < arr.length-1; i++) {
        for (int j = i; j >=0&& arr[j]>arr[j+1]; j--) {
     
            int temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
        }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
