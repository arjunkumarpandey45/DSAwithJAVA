
public class a_HasingBasics {
    public static void main(String[] args) {
        // Number Hasing

        // int[] arr = { 1, 11, 11, 13, 3, 42, 4, };

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
        String s = "Abcabce";
        int hash[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;

        }
//for Lower case s.charAt(i) - 'a'
// for upper case s.charAt(i) - 'A' 
        boolean []visited =new boolean[256];
        int n=s.length();
        while(n-->0){
            int num=s.charAt(n) ;
           if(!visited[num]){
            
             
            char ch =s.charAt(n);
            System.out.println("Frequency of " + ch + " is " + hash[num]);
            visited[num]=true;
           }

        }
    }
}
