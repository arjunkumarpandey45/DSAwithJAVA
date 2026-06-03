public class c_Palindrome {
    public static void main(String[] args) {
        System.out.println("--PALINDROM--");
        int num=8;
     
        int lastDigit=0;
        boolean isPalindrome=false;
        int reeversedNum=0;
        for (int i = num; i >0; i=i/10) {
            lastDigit=i%10;
            reeversedNum=reeversedNum*10+lastDigit;
        }
if(reeversedNum==num){
    isPalindrome=true;
}else{
    isPalindrome=false;
}
System.out.println(isPalindrome);
    }
}
