package Random;
import java.util.Scanner;

public class ConvertTemperature {
    public static double[] convertTemperature(double celsius) {
        return new double[] {
            celsius + 273.15,
            celsius * 1.80 + 32.00
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Celsius: ");
        double celsius = sc.nextDouble();

        double[] result = convertTemperature(celsius);

        System.out.println("Kelvin: " + result[0]);
        System.out.println("Fahrenheit: " + result[1]);

        sc.close();
    }
}

