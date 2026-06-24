

public class d_Palindrome {
    public static void main(String[] args) {
        String w ="mad4am";
    //    isPalindrome(0, w);
       if(isPalindrome(0, w)){
        System.out.println(w +" is Palindrome");
       }else{
        System.out.println(w + " is not Palidrome");
       }

    }
    public static boolean isPalindrome(int l,String w){
          if(l>=w.length()/2){
            return true;
        }
        if(w.charAt(l)!=w.charAt(w.length()-l-1)){
            return false;
        } 
      
       return  isPalindrome(l+1, w);
    }
}
