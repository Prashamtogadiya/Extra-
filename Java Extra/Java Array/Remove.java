import java.util.*;

public class Remove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int size = sc.nextInt();
        int a[] = new int[size];
        System.out.println("Enter Element you want to remove from Array : ");
        int remove = sc.nextInt();
        int[] b = new int[1];
        b[0] = '\0';

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            if (remove == a[i]) {
                a[i] = b[0];
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] : ");
            System.out.print(a[i]);
            System.out.println();
        }
       

    }
}