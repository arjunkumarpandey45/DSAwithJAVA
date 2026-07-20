import java.util.Arrays;

public class t_PeakElementII {
    public static void main(String[] args) {
        int [][]mat={{10,20,15},{21,30,14},{7,16,32}};
        System.out.println(Arrays.toString(peakElementII(mat)));
    }
    public static int[] peakElementII(int [][]arr) {
        int r=arr.length;
        int c=arr[0].length;
        int low=0;
        int high=c-1;
        while (low<=high) {

            int mid=low+(high-low)/2;
            int maxRowIndex=maxRowIndex(arr, r, c, mid);
          int left=mid-1>=0?arr[maxRowIndex][mid-1]:-1;
          int right=mid+1<c?arr[maxRowIndex][mid+1]:-1;
          if (arr[maxRowIndex][mid]>left&&arr[maxRowIndex][mid]>right) {
            return new int[]{maxRowIndex,mid};
          }else if (left>arr[maxRowIndex][mid]) {
            high=mid-1;
          }else{
            low=mid+1;
          }
            
        }
        return new int[]{-1,-1};
    }

    public static int maxRowIndex(int arr[][],int r,int c,int col){
        int index=0;
      int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            if (arr[i][col]>maxVal) {
                maxVal=arr[i][col];
                index=i;
            }
        }
        return index;
    }
}
