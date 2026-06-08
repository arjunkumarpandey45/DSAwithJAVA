package Recursion;

public class a_BasicRecursion {
    public static void main(String[] args) {
        // f1();
        // printName(6);
        printNum(5);
    }

    // static int c = 1;

    // public static void f1() {

    // if (c == 5) {
    // return;
    // } else {

    // System.out.println(c);
    // c++;
    // f1();
    // }

    // }
    // public static void printName(int n){
    // if(n==0){
    // return ;
    // }
    // System.out.println("Arjun");
    // printName(n-1);

    // }
    public static void printNum(int n) {
        // Work before recursion → Descending
        // Work after recursion → Ascending
        if (n == 0) {
            return;
        }
        // TC = O(n)
        // SC = O(n)
          System.out.println(n);
        printNum(n - 1);
      System.out.println(n);
    }
}
