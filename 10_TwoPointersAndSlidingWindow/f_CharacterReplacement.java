public class f_CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int windowSize = 0;

        int maxFreq = 0;
        int l = 0;
        int r = 0;
        int hashArr[] = new int[26];
        while (r < s.length()) {
            hashArr[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hashArr[s.charAt(r) - 'A']);
         int   windoLength = r - l + 1;
            int operationNeed =windoLength- maxFreq;
            if (operationNeed > k) {
                hashArr[s.charAt(l) - 'A']--;
                l++;

            }
            windoLength = r - l + 1;
            windowSize = Math.max(windoLength, windowSize);
            r++;
        }
        return windowSize;
    }
}
