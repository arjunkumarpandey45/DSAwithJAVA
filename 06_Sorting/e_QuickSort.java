public class e_QuickSort {
    public static void main(String[] args) {
        int[] arr ={4,6,8,10,2,5,7,9,1,3};
        System.out.println("ORIGINAL");
         for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        quickSort(arr, 0, arr.length - 1);
        System.out.println("SORTED");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
//                     [4,6,8,10,2,5,7,9,1,3]
                //            pivot=4
                //          /          \
                //   [1,3,2]          [7,9,5,6]
                //   pivot=1           pivot=7
                //   /    \            /      \
                //  []   [3,2]      [5,6]    [9]
                //       pivot=3     pivot=5
                //       /   \        /   \
                //     [2]   []     []   [6]
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partion(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public static int partion(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
           while (i <= high  && arr[i] <= pivot){
                i++;
            }
           while (j >= low  && arr[j] > pivot) {
                j--;
            }
      
            if(i<j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
        
    }
    public static void swap(int [] arr,int i,int j){
       int temp =arr[i];
       arr[i]=arr[j];
       arr[j]=temp; 
    }
}
