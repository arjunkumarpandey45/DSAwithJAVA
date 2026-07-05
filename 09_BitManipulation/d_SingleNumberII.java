public class d_SingleNumberII {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 6, 3, 3, 3 };
        // System.out.println(singleNumberIIV1(arr));
        System.out.println(singleNumberIIV2(arr));
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
}
