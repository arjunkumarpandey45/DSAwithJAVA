import java.util.*;

class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class m_WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> st = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            st.add(wordList.get(i));
        }

        st.remove(beginWord);

        while (!q.isEmpty()) {

            String word = q.peek().first;
            int step = q.peek().second;

            q.poll();

            if (word.equals(endWord)) {
                return step;
            }

            for (int i = 0; i < beginWord.length(); i++) {

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char[] replacementCharArr = word.toCharArray();

                    replacementCharArr[i] = ch;

                    String newWord = new String(replacementCharArr);

                    if (st.contains(newWord)) {

                        st.remove(newWord);

                        q.add(new Pair(newWord, step + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        

        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = Arrays.asList(
                "hot",
                "dot",
                "dog",
                "lot",
                "log",
                "cog"
        );

        int answer = ladderLength(beginWord, endWord, wordList);

        System.out.println("Shortest Transformation Length: " + answer);
    }
}