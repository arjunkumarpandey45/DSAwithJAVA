public class NumPattern {
    public static void main(String[] args) {
         printNumPattern(5);
//         printNumWithRepeation(4);
        printReverseNum(5);
    }

    public static void printNumPattern(int n) {
        // TC = O(n²) ✅ & SC = O(1) ✅
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void printNumWithRepeation(int n){
         // TC = O(n²) ✅ & SC = O(1) ✅
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

public static void printReverseNum(int n){
    // TC = O(n²) ✅ & SC = O(1) ✅
for (int i = n; i >=1; i--) {
    for (int j = 1; j <= i; j++) {
        System.out.print(j);
    }
    System.out.println();
    
}
}



}
