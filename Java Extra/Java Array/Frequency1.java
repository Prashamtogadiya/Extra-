
import java.util.Scanner;

public class Frequency1{

    public static double forwardInterpolation(double x, double[] xValues, double[] yValues) {
        int n = xValues.length;
        double result = yValues[0];
        double[] coefficients = new double[n];
        coefficients[0] = result;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                yValues[j] = (yValues[j + 1] - yValues[j]) / (xValues[j + i] - xValues[j]);
            }
            coefficients[i] = yValues[0];
        }

        for (int i = 1; i < n; i++) {
            double term = coefficients[i];
            for (int j = 0; j < i; j++) {
                term *= (x - xValues[j]);
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data points
        System.out.print("Enter the number of data points: ");
        int n = scanner.nextInt();

        double[] xValues = new double[n];
        double[] yValues = new double[n];

        System.out.println("Enter the data points:");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            xValues[i] = scanner.nextDouble();
            System.out.print("y[" + i + "]: ");
            yValues[i] = scanner.nextDouble();
        }

        // Input the value for interpolation
        System.out.print("Enter the value for interpolation (x): ");
        double x = scanner.nextDouble();

        // Perform interpolation
        double result = forwardInterpolation(x, xValues, yValues);

        // Display the result
        System.out.println("Interpolated value at x = " + x + ": " + result);

        scanner.close();
    }
}