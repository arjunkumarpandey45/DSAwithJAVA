package Random;


public class CountValidSubstrings {

    public static long countValidSubstrings(String s) {
        int n = s.length();
        long ans = 0;
        int lastInvalid = -1;

        for (int i = 0; i < n; i++) {

            if (i >= 2 && s.charAt(i - 2) == 'a'
                    && s.charAt(i - 1) == 'b'
                    && s.charAt(i) == 'c') {

                lastInvalid = i - 2;
            }

            ans += i - lastInvalid;
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abcabc";

        long result = countValidSubstrings(s);

        System.out.println(result);
    }
}

