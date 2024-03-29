public class tyy {
    public static void main(String[] args) {
        int sum = 0;
        int n = 5;
        int[] a ={1,2,3,5};
        sum = (n * (n + 1)) / 2;
        for (int i = 0; i <= a.length - 1; i++) {
            sum = sum- a[i];
        }
        System.out.println(sum);
    }

}
