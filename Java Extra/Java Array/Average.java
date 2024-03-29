import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of an array : ");
        int size = sc.nextInt();
        int []a=new int[size];
        double avg=0;
        float sum=0;
        for(int i =0;i<a.length;i++){
            System.out.print("Enter a["+i+"] : ");
            a[i]=sc.nextInt();
        }
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        avg=sum/size;
        System.out.println("Average of numbers are : "+avg);
    }
    
}
