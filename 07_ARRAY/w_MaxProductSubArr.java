public class w_MaxProductSubArr {
    public static void main(String[] args) {
       int []arr={0, 10, 1};
        System.out.println(maxProductSubArr(arr));
        ;
    }

    public static int maxProductSubArr(int[] arr) {
       int prefix = 1;
        int suffix = 1;

        int max = Integer.MIN_VALUE;

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (prefix == 0)
                prefix = 1;

            if (suffix == 0)
                suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n - 1 - i];

            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }
}
