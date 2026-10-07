import java.util.HashMap;

public class a_HasingBasics {
    public static void main(String[] args) {
        // Number Hashing

        // int[] arr = { 1,1,11, 11, 13, 3, 42, 4, };

        // int[] hash = new int[100];
        // for (int i = 0; i < arr.length; i++) {
        // hash[arr[i]]++;
        // }
        // Scanner sc = new Scanner(System.in);

        // int n = arr.length;
        // while (n-- > 0) {

        // int Number = arr[n];

        // System.out.println("Frequency of " + Number + " is " + hash[Number]);
        // }
        // sc.close();

        // String Hashing
        // String s = "Abcabce";
        // int hash[] = new int[256];
        // for (int i = 0; i < s.length(); i++) {
        // hash[s.charAt(i)]++;

        // }
        // // for Lower case s.charAt(i) - 'a'
        // // for upper case s.charAt(i) - 'A'
        // boolean[] visited = new boolean[256];
        // int n = s.length();
        // while (n-- > 0) {
        // int num = s.charAt(n);
        // if (!visited[num]) {

        // char ch = s.charAt(n);
        // System.out.println("Frequency of " + ch + " is " + hash[num]);
        // visited[num] = true;
        // }

        // }

        // number hashing via Hasmap
        // int[] arr = { 1, 11, 11, 13, 3, 42, 4, };
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for (int i = 0; i <arr.length; i++) {
        // map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        // }
        // for (Integer key : map.keySet()) {
        // System.out.println("Frequency of "+ key + " is "+map.get(key));
        // }

        // String hashing via Hasmap
        // String s = "Abcabce";
        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // // for (Character key : map.keySet()) {
        // // System.out.println("Frequency of "+key+" is "+map.get(key));
        // // }
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     System.out.println(
        //             "Frequency of "
        //                     + entry.getKey()
        //                     + " is "
        //                     + entry.getValue());
        // }

//         int[] arr = { 1,1, 11, 11, 13, 3, 42, 4, };
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for (int i = 0; i <arr.length; i++) {
//         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

//         }
//         int minFreq=Integer.MAX_VALUE;
//         int minEle=-1;
//         for (Integer key : map.keySet()) {
            
//             if(map.get(key)<=minFreq){
//                 minFreq=map.get(key);
//                 minEle=key;
//             }
            
        
//         }
// System.out.println("Lowest frequency of "+ minEle+ " is "+minFreq);

// highest frequency 
     int[] arr = { 1,1,1,1,1,1, 11, 11, 13, 3, 42, 4, };
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <arr.length; i++) {
        map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }
        int maxFreq=Integer.MIN_VALUE;
        int maxEle=-1;
        for (Integer key : map.keySet()) {
            
            if(map.get(key)>=maxFreq){
                maxFreq=map.get(key);
                maxEle=key;
            }
            
        
        }
System.out.println("Highest frequency of "+ maxEle+ " is "+maxFreq);

    }
}


