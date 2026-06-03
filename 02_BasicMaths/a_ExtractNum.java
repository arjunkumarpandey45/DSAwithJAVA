
public class a_ExtractNum {
    public static void main(String[] args) {
        int num =1998;
        // int v=0;
        // // while (num>0) { 
        // //      v=num%10;
        // //      System.out.print(v);
        // //   num=  num/10;
        // //     //  System.out.println(v);
        // // }
        // for (int i = num; i >0; i=i/10) {
        //     v=i%10;
        //     System.out.print(v);
        // }
      int digit=(int )Math.log10(num)+1;
      System.out.println(digit);
    }
}
