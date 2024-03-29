import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an Array : ");
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            System.out.print("Enter a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
        for (int i = a.length-1,n=0;i>=0; i--) {
           System.out.println("a["+n+"] : " + a[i]);
           n++;
        }
       

    }

}
