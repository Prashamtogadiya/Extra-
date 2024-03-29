import java.util.*;

public class Copy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array : ");
        int size = sc.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] : " + b[i]);
        }
    }

}
