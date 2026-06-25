import java.util.ArrayList;
import java.util.Arrays;

public class h_RearrangeBySign {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -1, -2, -3 };
     System.out.println(   rearrangeBySign(arr));;
        
    }

    public static ArrayList<Integer> rearrangeBySign(int[] arr) {
        ArrayList<Integer> ds = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ds.add(0);
        }
        int pInd = 0;
        int nInd = 1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ds.set(pInd, arr[i]);
                pInd += 2;
            } else {
                ds.set(nInd, arr[i]);
                nInd += 2;
            }
        }
        return ds;
    }
}
