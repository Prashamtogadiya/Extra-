import java.util.*;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an Array : ");
        int size = sc.nextInt();
        float[] a = new float[size];
        float sum = 0;

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextFloat();
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("Sum of all element of Array is : " + sum);
    }

}
