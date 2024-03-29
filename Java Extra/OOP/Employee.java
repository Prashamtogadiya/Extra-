class Emp {
    int salary;
    String name;
    int sal1;
    int sal2;
    int sal3;
       public int getSalary(){
        return salary;
       }

       Emp(){
            this.salary=500;
            this.name="prasham";
       }
        Emp(int j){
            this.salary=salary;
       }

       public Emp(int sal1,int sal2,int sal3) {
            this.sal1=sal1;
            this.sal2=sal2;
            this.sal3=sal3;

       }
}

public class Employee{
    public static void main(String[] args) {
        Emp e = new Emp();
        Emp e1 = new Emp(5);
        System.out.println(e1.salary);
        

    }


}