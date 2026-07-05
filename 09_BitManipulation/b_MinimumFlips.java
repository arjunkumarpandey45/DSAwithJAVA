public class b_MinimumFlips {
    public static void main(String[] args) {
        int start=10;
        int goal=7;
System.out.println(minimumFlip(start, goal));
    }
    public static int  minimumFlip(int start,int goal){
        int c=0;
        int num=start^goal;
        while (num!=0) {
            num=num&(num-1);
            c++;
        }
        return c;
    }
}
