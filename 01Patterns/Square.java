import java.util.Scanner;

public class Square {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Give length of the Square: ");
        int n = sc.nextInt();

        printSquare(n);

        sc.close();
    }

    public static void printSquare(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}