import java.util.*;

public class inputPresentOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an Array : ");
        int size = sc.nextInt();
        int[] a = new int[size];
        System.out.print("Enter element you want to find in Araay : ");
        int input = sc.nextInt();

        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == input) {
                System.out.println("The element you want to find in Araay is at index : a[" + i + "]");

            }
        }

    }

}
