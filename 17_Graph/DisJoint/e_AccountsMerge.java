package DisJoint;

import java.util.*;

class DSU {

    int[] parent;
    int[] rank;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }

    void unionByRank(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    void unionBySize(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}

public class e_AccountsMerge {

    public static List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    dsu.unionByRank(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        HashMap<Integer, List<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {
            int parent = dsu.find(map.get(email));

            if (!merged.containsKey(parent)) {
                merged.put(parent, new ArrayList<>());
            }

            merged.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry
                : merged.entrySet()) {

            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> account = new ArrayList<>();

            int parent = entry.getKey();
            account.add(accounts.get(parent).get(0));
            account.addAll(emails);

            ans.add(account);
        }

        return ans;
    }

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList(
                "John", "johnsmith@mail.com", "john_newyork@mail.com"));

        accounts.add(Arrays.asList(
                "John", "johnsmith@mail.com", "john00@mail.com"));

        accounts.add(Arrays.asList(
                "Mary", "mary@mail.com"));

        accounts.add(Arrays.asList(
                "John", "johnnybravo@mail.com"));

        List<List<String>> result = accountsMerge(accounts);

        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}
