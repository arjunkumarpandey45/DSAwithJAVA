import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class e_SingleNumberIII {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 4, 3, 3 };
        System.out.println(Arrays.toString(singleNumberIIIV1(arr)));
         System.out.println(Arrays.toString(singleNumberIIIV2(arr)));
        ;
    }

    public static int[] singleNumberIIIV1(int arr[]) {
        int a[] = new int[2];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                a[index++] = m.getKey();
            }
        }
        return a;

    }

    public static int[] singleNumberIIIV2(int arr[]) {
        int a[] = new int[2];
        long xor = 0;
        int rightMostBit = 0;
        int b1 = 0;
        int b2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
            
        }
        // rightMostBit woh bit hoti hai jahan dono unique numbers ki value alag (0 aur 1) hoti hai, jabki duplicate numbers us bit par same hote hain aur same group mein jaakar XOR se cancel ho jaate hain.
        rightMostBit=(int)(xor&-xor);
    //  rightMostBit = (int) ((int) (xor^(xor-1))&xor);
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightMostBit) == 0) {
                b1 = b1 ^ arr[i];
            } else {
                b2 = b2 ^ arr[i];
            }
        }
        a[0] = b1;
        a[1] = b2;
        return a;
    }
}
