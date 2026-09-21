package TopologicalSort;

import java.util.*;

class d_AlienDictionary {

    public String alienOrder(String[] words) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[26];
        boolean[] present = new boolean[26];

        
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                present[ch - 'a'] = true;
            }
        }

       
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

      
        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());

            boolean found = false;

            for (int j = 0; j < len; j++) {

                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {

                    int u = c1 - 'a';
                    int v = c2 - 'a';

                    graph.get(u).add(v);
                    indegree[v]++;

                    found = true;
                    break;
                }
            }

          
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }

       
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {

            if (present[i] && indegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!q.isEmpty()) {

            int node = q.remove();

            ans.append((char) (node + 'a'));

            for (int next : graph.get(node)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

       
        int totalCharacters = 0;

        for (int i = 0; i < 26; i++) {

            if (present[i]) {
                totalCharacters++;
            }
        }

        if (ans.length() != totalCharacters) {
            return "";
        }

        return ans.toString();
    }
}