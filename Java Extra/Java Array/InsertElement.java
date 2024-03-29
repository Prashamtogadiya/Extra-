import java.util.*;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an Araay : ");
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
        System.out.print("Enter index at which you want to add element : ");
        int element = sc.nextInt();
        for (int i = 0; i < a.length; i++) {
            if (i == element) {
                System.out.print("Enter Element at index "+element+": ");
                a[i] = sc.nextInt();
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "] : ");
            System.out.println(a[i]);
        }

    }

}
