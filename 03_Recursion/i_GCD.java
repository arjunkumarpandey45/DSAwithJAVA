

public class i_GCD {
    static void main() {
        System.out.println(getGCD(12, 15));
    }

    public static int getGCD(int n1, int n2) {
        if(n1==0 ) return n2;
  return   getGCD(n2%n1,n1);
}

}
