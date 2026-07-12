public class i_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int startingIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int m = t.length();
        int l = 0;
        int[] hash = new int[256];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        for (int r = 0; r < s.length(); r++) { 
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            while (count == m) {
                int currentLen = r - l + 1;         
                if (currentLen < minLen) {
                    minLen = currentLen;
                    startingIndex = l;
                } 
              hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
        }

        return startingIndex == -1
                ? ""
                : s.substring(startingIndex, startingIndex + minLen);
    }
}