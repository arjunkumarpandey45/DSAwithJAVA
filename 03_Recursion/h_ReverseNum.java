package Recursion;

public class h_ReverseNum {
    static void main() {
        reverseNum(23,0);
    }
    public static void reverseNum(int n,int r){
        if(n==0) {
            System.out.println(r);
            return;
        }
        reverseNum(n/10,r*10+n%10);
    }
}