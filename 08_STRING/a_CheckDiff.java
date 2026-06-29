import java.util.HashMap;
import java.util.Map;

public class a_CheckDiff {
    public static void main(String[] args) {
        String a = "aea";
        String b = "baea";
        System.out.println(findTheDifference(a, b));
        ;
    }

    public static char findTheDifference(String s, String t) {

        char d = '\0';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() == -1) {
                return i.getKey();
            }
        }
        return d;

    }

    public char findTheDifferenceV2(String s, String t) {

        int[] freq = new int[26];

        // s ke characters count karo
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // t ke characters subtract karo
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        // Jiski frequency -1 hogi wahi extra character hai
        for (int i = 0; i < 26; i++) {
            if (freq[i] == -1) {
                return (char) (i + 'a');
            }
        }

        return '\0';
    }

       public char findTheDifferenceV3(String s, String t) {

        char ans = 0;

        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }

        return ans;
    }
}
