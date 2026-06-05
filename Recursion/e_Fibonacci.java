package Recursion;

public class e_Fibonacci {
    public static void main(String[] args) {
        System.out.println("--Fibonacci By Recursion--");
for (int i = 0; i < 10; i++) {
    System.out.print(fibonnacci(i));
    System.out.print(" ");
}
    }
    //TC = O(2^n)
// SC = O(n)
    public static int  fibonnacci (int n){
     if(n<0){
        return 0;
     }
  if (n<=1){
    
    return n;
  }
 
  
return fibonnacci(n-1)+fibonnacci(n-2);

    }
}
