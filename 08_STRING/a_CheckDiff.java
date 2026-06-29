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
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) -1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) +1);
        }
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() == -1) {
                d = i.getKey();
            }
        }
        return d;
        
    }

}
