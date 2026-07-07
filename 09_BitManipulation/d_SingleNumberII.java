import java.util.Arrays;

public class d_SingleNumberII {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 4, 3, 3 };
        // System.out.println(singleNumberIIV1(arr));
        System.out.println(Arrays.toString(singleNumberIII(arr)));
        ;
    }

    public static int singleNumberIIV1(int[] arr) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }

            }
            if (count % 3 == 1) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }

    public static int singleNumberIIV2(int[] arr) {
        int ones = 0;
        int twos = 0;

        for (int num : arr) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;

    }

    public static int[] singleNumberIII(int[] arr) {
        int a[] = new int[2];
        int xor = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int rightMostBit = xor & -xor;
        int b1 = 0;
        int b2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightMostBit) == 0) {
                b1 ^= arr[i];
            } else {
                b2 ^= arr[i];
            }
        }
        a[index++] = b1;
        a[index] = b2;
        return a;
    }

}
