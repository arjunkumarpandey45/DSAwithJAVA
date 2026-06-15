
public class a_SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, -4, 268, 9, 12, 3 };
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
         
                if (arr[minIndex] > arr[j]) {

                   minIndex=j;
                }
            }
             int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
