public class b_ReverseNum {
    public static void main(String[] args) {
        System.out.println("--Reverse Number");
        int num=991;
        int lastDigit;
        int reeversedNum=0;
        while(num>0){
            lastDigit=num%10;
reeversedNum=reeversedNum*10+lastDigit;
       num= num/10;
        }
        System.out.println(reeversedNum);
    }
}
