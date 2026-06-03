public class d_ArmstrongNum {
    public static void main(String[] args) {
        System.err.println("--ARMSTRONG NUMBER--");
        int num=100;
        int lastDigit=0;
int noOfDigit=(int)Math.floor( Math.log10(num))+1;
System.out.println(noOfDigit);
int ARMSTRONGNum=0;
for (int i = num; i >0; i=i/10) {
lastDigit =i%10;
System.out.println(lastDigit);
    ARMSTRONGNum=(int)Math.pow(lastDigit, noOfDigit) +ARMSTRONGNum;
}
boolean isArmsSTrong=(ARMSTRONGNum==num);
System.out.println(ARMSTRONGNum + " is Armstrong ?" + isArmsSTrong);
    }
}
