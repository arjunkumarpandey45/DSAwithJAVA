public class e_NumberOfSubstrings {
   public static void main(String[] args) {
      String s = "aaacb";
      System.out.println(numberOfSubStringOptimal(s));
   }

   public static int numberOfSubString(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
         int[] hash = new int[3];
         for (int j = i; j < s.length(); j++) {
            hash[s.charAt(j)-'a']=1;
            if(hash[0]+hash[1]+hash[2]==3){
               count+=s.length()-j;
               break;
            }
         }
      }
      return count;
   }
   public static int numberOfSubStringOptimal(String s){
      int count=0;
      int a=-1;
      int b=-1;
      int c=-1;
      for (int i = 0; i < s.length(); i++) {
         if(s.charAt(i)=='a'){
            a=i;

         }else if(s.charAt(i)=='b'){
            b=i;
         }else{
            c=i;
         }
         // System.out.println(a);
         // System.out.println(b);
         // System.out.println(c);
         if(a>-1&&b>-1&&c>-1){
            count+=Math.min(a, Math.min(c, b))+1;
           
         }
          System.out.println(count);
      }
      return count;
   }
}
