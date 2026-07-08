import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b_LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        // System.out.println(longestSubstring(s));
        System.out.println(longestSubstringOptimal(s));
    }

    public static int longestSubstring(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[256];
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (hash[ch] == 1) {
                    break;
                }
                hash[ch] = 1;
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }

        return maxlen;
    }

    public static int longestSubstringOptimal(String s) {
        int max = 0;
        int l = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
                 map.put(ch, i);
            } else {
                map.put(ch, i);
               
                max = Math.max(max, i - l + 1);
                System.out.println(max+ " "+i+" "+l+" " +ch);
            }
        }

        return max;
    }
}
