public class a_BasicOfBit {
    public static void main(String[] args) {
        int a = 15;
        int b = 9;
        // swapTwoNums(a, b);
        changeInBinary(a);
        // checkBitSet(b, 2);
        // setBit(b, 2);
        // clearBit(a, 1);
        // setLastBit(b);
        // toogleBit(a, 2);
        // System.out.println(isPowerOfTwo(a));
        countBit(a);
    }

    public static void swapTwoNums(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }

    public static void changeInBinary(int a) {
        StringBuilder s1 = new StringBuilder();

        while (a > 0) {

            if (a % 2 == 0) {
                s1.append("0");

            } else {
                s1.append("1");
            }
            a /= 2;
        }
        s1.reverse();
        System.out.println(s1);
    }

    public static void checkBitSet(int a, int ith) {
        // left shift
        System.out.println("By Left");
        if ((a & (1 << ith)) != 0) {
            System.out.println(ith + " is bitSet");

        } else {
            System.out.println(ith + " is not bitSet");

        }
        // by rightShift
        System.out.println("By Right");
        if (((a >> ith) & 1) != 0) {
            System.out.println(ith + " is bitSet");
        } else {
            System.out.println(ith + " is not bitSet");

        }
    }

    public static void setBit(int b, int ith) {
        b = (b | (1 << ith));
        System.out.println("After seting Bit value is " + b);
    }

    public static void clearBit(int b, int ith) {
        b = (b & ~(1 << ith));
        System.out.println("After clearing Bit value is " + b);
    }

    public static void toogleBit(int b, int ith) {
        b = (b ^ (1 << ith));
        System.out.println("After toogle Bit value is " + b);
    }

    public static void setLastBit(int b) {
        b = (b & (b - 1));
        System.out.println("After Set last Bit value is " + b);
    }

    public static boolean isPowerOfTwo(int a) {
        return a > 0 && (a & (a - 1)) == 0;

    }

    public static void countBit(int a) {
        int c = 0;
        // while (a > 0) {
        //      if (a==1){
        //         c++;
        //         break;
        //     }
            
        //         c+=a&1;
        //       a=a>>1;
        //     }
        while (a!=0) {
          a=  (a&(a-1));
         c++;       
            
        }
           System.out.println(c);
         
        }
         
    }


