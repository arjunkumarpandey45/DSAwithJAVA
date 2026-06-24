
import java.util.Arrays;

public class c_ReverseArr {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6 };

        System.out.println("Current ARRAY");
        System.out.println(Arrays.toString(arr));

        System.out.println("--Reverse array using RecursionByTwoPointer--");

        reverseByTwoPointer(0, arr.length - 1, arr);

        System.out.println(Arrays.toString(arr));
 System.out.println("--Reverse array using RecursionByonePointer--");

        reverseByOnePointer(0, arr);
         System.out.println(Arrays.toString(arr));
    }

    public static void reverseByTwoPointer(int l, int r, int[] a) {

        // Base Case
        if (l >= r) {
            return;
        }

        // Swap
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;

        // Recursive Call
        reverseByTwoPointer(l + 1, r - 1, a);
    }

    public static void reverseByOnePointer(int l, int[] a) {
                
        if (l >= (a.length) / 2) {
            return;

        }
        int temp=a[l];
        a[l]=a[a.length-l-1];
        a[a.length-l-1]=temp;
        
        reverseByOnePointer(l+1, a);
      
    }

}