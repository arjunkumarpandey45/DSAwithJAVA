import java.util.Arrays;

public class r_MergeSortedArr {

    public static void main(String[] args) {
        int[] arr1 = { 4 };
        int[] arr2 = { 0, 2, 6, 8, 9 };
        mergeSortedArrOptimal2(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void mergeSortedArrBrute(int[] a1, int[] a2) {
        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {
            while (i != a1.length && a1[i] < a2[j])
                i++;
            if (i != a1.length && a1[i] >= a2[j]) {
                int t = a1[i];
                a1[i] = a2[j];
                a2[j] = t;

                i++;
            }

            while (j != a2.length - 1 && a2[j] > a2[j + 1]) {
                int temp = a2[j];
                a2[j] = a2[j + 1];
                a2[j + 1] = temp;
                j++;
            }
            j = 0;

        }
    }
   public static void mergeSortedArrOptimal1(int []a1,int []a2){
    int i=a1.length-1;
    int j=0;
    while(i>=0&&j<a2.length){
        if(a1[i]>a2[j]){
            int temp=a1[i];
            a1[i]=a2[j];
            a2[j]=temp;
            j++;
            i--;
        }else{
            
            j++;
        }
        
    }
    Arrays.sort(a1);
        Arrays.sort(a2);
   }
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void mergeSortedArrOptimal2(int[] a1, int[] a2) {

        int n = a1.length;
        int m = a2.length;

        int gap = nextGap(n + m);

        while (gap > 0) {

            int left = 0;
            int right = gap;

            while (right < n + m) {

                // Both pointers in a1
                if (left < n && right < n) {

                    if (a1[left] > a1[right]) {
                        int temp = a1[left];
                        a1[left] = a1[right];
                        a1[right] = temp;
                    }

                }
                // left in a1, right in a2
                else if (left < n && right >= n) {

                    if (a1[left] > a2[right - n]) {
                        int temp = a1[left];
                        a1[left] = a2[right - n];
                        a2[right - n] = temp;
                    }

                }
                // Both pointers in a2
                else {

                    if (a2[left - n] > a2[right - n]) {
                        int temp = a2[left - n];
                        a2[left - n] = a2[right - n];
                        a2[right - n] = temp;
                    }

                }

                left++;
                right++;
            }

            gap = nextGap(gap);
        }
    }
}