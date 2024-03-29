import java.util.*;

public class Equality {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int flag = 0;
        System.out.print("Enter size of array a : ");
        int size1 = sc.nextInt();
        System.out.print("Enter size of array b : ");
        int size2 = sc.nextInt();
        int[] a = new int[size1];
        int[] b = new int[size2];

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a [" + i + "] :");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print("Enter b [" + i + "] :");
            b[i] = sc.nextInt();
        }

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    flag++;
                    System.out.println("Not the same array");
                    break;
                }

            }
            if (flag == 0) {
                System.out.println("Array a and b both are same");
            }
        } else {
            System.out.println("Array are not of same size");
        }

    }
}
